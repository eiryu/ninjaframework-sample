package forms;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/15
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public enum Sex {
    MALE("男性"), FEMALE("女性");

    private String label;

    private Sex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
