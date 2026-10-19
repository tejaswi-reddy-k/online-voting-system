package com.voting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RootController {

    @GetMapping({"/", "/api"})
    public ResponseEntity<Map<String, Object>> root() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "ONLINE");
        response.put("service", "Online Voting System REST API");
        response.put("message", "Backend is running smoothly! Open the frontend at http://localhost:5173 to test visually.");
        response.put("frontendUrl", "http://localhost:5173");

        Map<String, Object> endpoints = new LinkedHashMap<>();

        endpoints.put("1_public_endpoints (open in browser)", List.of(
            Map.of("method", "GET", "url", "/api/elections", "description", "List all elections with real-time state calculation"),
            Map.of("method", "GET", "url", "/api/elections/E1", "description", "Fetch detailed metadata for election E1"),
            Map.of("method", "GET", "url", "/api/candidates/election/E1", "description", "Candidate manifestos and nominations for election E1"),
            Map.of("method", "GET", "url", "/api/votes/results/E1", "description", "Aggregated vote tallies and certified percentages for election E1"),
            Map.of("method", "POST", "url", "/api/auth/login", "description", "Authenticate credentials and receive JWT Bearer token"),
            Map.of("method", "POST", "url", "/api/auth/register-voter", "description", "Enroll new voter (>= 18 yrs), generates Voter ID"),
            Map.of("method", "POST", "url", "/api/auth/register-candidate", "description", "Elevate voter to Candidate (>= 25 yrs)")
        ));

        endpoints.put("2_voter_endpoints (requires Bearer JWT with ROLE_VOTER)", List.of(
            Map.of("method", "POST", "url", "/api/votes/cast", "description", "Cast atomic vote during VOTING_OPEN window"),
            Map.of("method", "GET", "url", "/api/votes/has-voted/{id}", "description", "Check if logged-in voter has participated in election"),
            Map.of("method", "GET", "url", "/api/voters/profile", "description", "Fetch profile of logged-in user")
        ));

        endpoints.put("3_candidate_endpoints (requires Bearer JWT with ROLE_CANDIDATE)", List.of(
            Map.of("method", "POST", "url", "/api/candidates/register-for-election", "description", "Submit nomination manifesto and key promises"),
            Map.of("method", "GET", "url", "/api/candidates/is-registered?electionId={id}", "description", "Check candidate nomination status")
        ));

        endpoints.put("4_admin_endpoints (requires Bearer JWT with ROLE_ADMIN)", List.of(
            Map.of("method", "POST", "url", "/api/elections", "description", "Create a new election lifecycle"),
            Map.of("method", "POST", "url", "/api/elections/{id}/publish-results", "description", "Publish and certify election outcome"),
            Map.of("method", "GET", "url", "/api/voters", "description", "List all registered voters in system"),
            Map.of("method", "GET", "url", "/api/candidates", "description", "List all registered candidates"),
            Map.of("method", "GET", "url", "/api/audit-logs", "description", "Full immutable audit ledger of system actions")
        ));

        response.put("endpoints", endpoints);

        response.put("testingTools", Map.of(
            "swaggerUi", "http://localhost:8080/swagger-ui/index.html",
            "frontendApp", "http://localhost:5173",
            "postmanCollection", "./OnlineVotingSystem_Postman_Collection.json"
        ));

        return ResponseEntity.ok(response);
    }
}
