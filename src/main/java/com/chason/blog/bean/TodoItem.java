package com.chason.blog.bean;

/**
 * Todolist事列项
 *
 * @author cang
 * @date 2017-10-08
 */
public class TodoItem {

    private String label;
    private boolean finished;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
