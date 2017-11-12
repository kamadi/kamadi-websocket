package kz.kamadi.websocket.model;

import com.google.gson.annotations.SerializedName;

public enum Action {
    @SerializedName("status")
    STATUS("status"),
    @SerializedName("info")
    INFO("info"),
    @SerializedName("write")
    WRITE("write"),
    @SerializedName("oncardover")
    ON_CARD_OVER("oncardover");

    private final String text;

    /**
     * @param text
     */
    private Action(final String text) {
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
