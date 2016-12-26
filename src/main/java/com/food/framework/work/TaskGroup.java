package com.food.framework.work;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liubihui on 16/12/23.
 */
public class TaskGroup {

    /**
     * 工作组人员列表
     */
    private Queue<ITask> innerTaskQueue = new LinkedList<ITask>();

    private TaskGroup() {
    }

    public static TaskGroup taskGroup = new TaskGroup();

    public static TaskGroup getInstance() {
        return taskGroup;
    }

    /**
     * 取一个任务
     *
     * @return
     */
    public ITask getTask() {
        if (taskGroup.innerTaskQueue.peek() != null) {
            return taskGroup.innerTaskQueue.poll();
        }
        return null;
    }

    /**
     * 将一个任务放入队列
     *
     * @param task
     */
    public void addTask(ITask task) {
        taskGroup.innerTaskQueue.add(task);
    }

    /**
     * 从队列里删除一个任务
     *
     * @param task
     */
    public void reduceTask(ITask task) {
        taskGroup.innerTaskQueue.remove(task);
    }
}
