package com.portobello.eval.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class PracticalMessage implements Serializable {
    @Id
    private String id;
    private String payload;
    private String status;

    public PracticalMessage(@JsonProperty("payload") String payload, @JsonProperty("status") String status) {
        this.payload = payload;
        this.status = status;
    }

    @Override
    public String toString() {
        return "PracticalMessage{" +
                "id='" + id + '\'' +
                ", payload='" + payload + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
