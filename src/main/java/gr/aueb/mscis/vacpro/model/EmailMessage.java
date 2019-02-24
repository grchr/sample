package gr.aueb.mscis.vacpro.model;

/**
 * The type Email message.
 */
public class EmailMessage {
    private String from;
    private String to;
    private String subject;
    private String body;

    /**
     * Instantiates a new Email message.
     */
    public EmailMessage() {
    }

    /**
     * Instantiates a new Email message.
     *
     * @param from    the from
     * @param to      the to
     * @param subject the subject
     * @param body    the body
     */
    public EmailMessage(final String from, final String to, final String subject, final String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(final String from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(final String to) {
        this.to = to;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(final String body) {
        this.body = body;
    }


    @Override
    public String toString() {
        return "{\"EmailMessage\":{"
                + "\"from\":\"" + from + "\""
                + ",\"to\":" + to + "\""
                + ",\"subject\":" + subject + "\""
                + ",\"body\":" + body + "\""
                + "}}";
    }
}