package C.i;

/**
 * 状态
 * @author 周士钰
 * @date 2024/7/20 下午4:13
 */
public enum State {

    NORMAL("正常"),
    LAZY("懒惰");

    final String title;

    State(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
