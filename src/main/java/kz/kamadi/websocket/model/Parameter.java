package kz.kamadi.websocket.model;

import com.google.gson.annotations.SerializedName;

public enum Parameter {
    @SerializedName("start")
    START("start"),
    @SerializedName("stop")
    STOP("stop");

    private final String text;

    /**
     * @param text
     */
    private Parameter(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
