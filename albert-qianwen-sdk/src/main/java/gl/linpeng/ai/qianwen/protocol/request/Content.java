package gl.linpeng.ai.qianwen.protocol.request;

/**
 * Content 用于精细化问询
 *
 */
public class Content {
    private String image;
    private String text;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
