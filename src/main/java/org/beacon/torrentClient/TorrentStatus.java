package org.beacon.torrentClient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TorrentStatus {
    @JsonProperty("status")
    private String status = "unknown";
    @JsonProperty("progress")
    private String progress = "0";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
