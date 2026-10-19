package com.voting.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class FlexibleLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FALLBACK_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd['T'][ ]HH:mm[:ss]")
            .optionalStart()
            .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
            .optionalEnd()
            .optionalStart()
            .appendPattern("X")
            .optionalEnd()
            .toFormatter();

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String text = p.getText().trim();
        if (text.isEmpty()) {
            return null;
        }

        try {
            // Handles ISO offsets like 2026-10-15T04:23:33.864Z or +05:30
            if (text.endsWith("Z") || text.contains("+") || (text.lastIndexOf('-') > 10)) {
                return OffsetDateTime.parse(text).toLocalDateTime();
            }
            return LocalDateTime.parse(text);
        } catch (Exception ignored) {
            // Fallback for custom or relaxed date/time formats
            return LocalDateTime.parse(text, FALLBACK_FORMATTER);
        }
    }
}
