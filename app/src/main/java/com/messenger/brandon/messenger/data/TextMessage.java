package com.messenger.brandon.messenger.data;
import java.util.Date;

/**
 * Created by Brandon on 3/29/2017.
 *
 * This is the text message object. Everything about a text message will be stored here.
 *
 * @version 1
 */
public class TextMessage {

    //Direction Flags
    /**
     * The message has been sent to this device. Meaning the number is storing the user who
     * sent the text message to this device.
     *
     * This is applied to direction.
     */
    public static final char INCOMING = 'I';

    /**
     * The message is being sent from this device. Meaning the number is storing the user it's
     * being directed to the message.
     *
     * This is applied to direction.
     */
    public static final char OUTGOING = 'O';

    //Status Flags
    /**
     * We handled the message on our side, waiting for Android system to send the message.
     *
     * This is applied to the status.
     */
    public static final char QUEUED = 'Q';

    /**
     * Message was sent over the network.
     *
     * This is applied to the status.
     */
    public static final char SENT = 'S';

    /**
     * Message was received on the other device.
     *
     * This is applied to the status.
     */
    public static final char RECEIVED = 'R';

    /**
     * Message was looked at on the other device.
     *
     * This is applied to the status.
     */
    public static final char LOOK = 'L';

    /**
     * Message failed for some reason. Error string variable should have more
     * information on the error that occurred.
     *
     * This is applied to the status.
     */
    public static final char FAILED = 'F';

    /**
     * Blacklisted number or spam. It will not go through to the user.
     */
    public static final char IGNORED = 'I';

    // Storage Variables

    /**
     * The message of the text message.
     */
    public String message;

    /**
     * The phone number from where it came from.
     */
    public String number;

    /**
     * Time stamp of creation.
     */
    public Date timestamp;

    /**
     * ID given by the cell service.
     */
    public long serverId;

    /**
     * Indicates the direction of the message. If it's being sent or received.
     */
    public char direction;

    /**
     * Indicates the status of the message.
     */
    public char status;

    /**
     * The id given by our database system.
     */
    public long id;

    public TextMessage(String message, String number, Long serverId){
        this.message = message;
        this.number = number;
        this.serverId = serverId;
        this.timestamp = new Date();
        this.direction = INCOMING;
        this.status = QUEUED;
    }

    public String getStatusText(){
        switch (status){
            case RECEIVED:
                return "Received";
            case QUEUED:
                return "Queued";
            case SENT:
                return "Sent";
            case IGNORED:
                return "Ignored";
            case LOOK:
                return "Read";
            case FAILED:
                if(direction == OUTGOING){
                    return "Client Failed";
                } else {
                    return "Server Failed";
                }
            default:
                return "No Status Found";
        }
    }

    public boolean match(Object other) {
        return other instanceof TextMessage && ((TextMessage) other).id == this.id;
    }

}
