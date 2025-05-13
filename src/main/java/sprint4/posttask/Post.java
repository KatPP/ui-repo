package sprint4.posttask;

import java.util.ArrayList;
import java.util.Arrays;

public class Post {
    private String title;
    private String content;
    private String[] tags;
    private ArrayList<PostComment> comments;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setComments(ArrayList<PostComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        String result = "Post{" +
                "title='" + title + '\'';
        if(content != null) {
            result = result + ", content.length='" + content.length() + '\'';
        } else {
            result = result + ", content='" + content + '\'';
        }
        return result +
                ", tags=" + Arrays.toString(tags) +
                ", comments=" + comments +
                '}';
    }
}
