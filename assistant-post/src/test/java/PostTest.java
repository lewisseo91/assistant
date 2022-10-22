import org.junit.jupiter.api.Test;

public class PostTest {

    @Test
    public void 등록한다() {
        Post post = new Post();
        post.create();
    }

    @Test
    public void 수정한다() {
        Post post = new Post();
        post.update();
    }

    @Test
    public void 삭제한다() {
        Post post = new Post();
        post.delete();
    }
}
