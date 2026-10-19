package com.voting.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.voting.config.FlexibleLocalDateTimeDeserializer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ElectionRequest {

    @NotBlank(message = "Election title is required")
    @Schema(example = "City Council Elections 2026")
    private String title;

    @Schema(example = "Elections conducted for the city municipal council.")
    private String description;

    @NotNull(message = "Registration start time is required")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    @Schema(example = "2026-10-15T04:23:33")
    private LocalDateTime registrationStart;

    @NotNull(message = "Registration end time is required")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    @Schema(example = "2026-10-15T10:23:33")
    private LocalDateTime registrationEnd;

    @NotNull(message = "Voting start time is required")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    @Schema(example = "2026-10-15T10:23:33")
    private LocalDateTime votingStart;

    @NotNull(message = "Voting end time is required")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    @Schema(example = "2026-10-15T22:33:33")
    private LocalDateTime votingEnd;

    public ElectionRequest() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRegistrationStart() {
        return registrationStart;
    }

    public void setRegistrationStart(LocalDateTime registrationStart) {
        this.registrationStart = registrationStart;
    }

    public LocalDateTime getRegistrationEnd() {
        return registrationEnd;
    }

    public void setRegistrationEnd(LocalDateTime registrationEnd) {
        this.registrationEnd = registrationEnd;
    }

    public LocalDateTime getVotingStart() {
        return votingStart;
    }

    public void setVotingStart(LocalDateTime votingStart) {
        this.votingStart = votingStart;
    }

    public LocalDateTime getVotingEnd() {
        return votingEnd;
    }

    public void setVotingEnd(LocalDateTime votingEnd) {
        this.votingEnd = votingEnd;
    }
}
