package com.food.framework.work;

/**
 * Created by liubihui on 16/12/23.
 */
public class WorkDispatch {

    TaskGroup taskGroup = null;
    WorkerGroup workerGroup = null;

    public WorkDispatch(TaskGroup taskGroup, WorkerGroup workerGroup) {
        this.taskGroup = taskGroup;
        this.workerGroup = workerGroup;
    }

    public void addTask(ITask task) {
        this.taskGroup.addTask(task);
    }

    public void addWorker(IWorker worker) {
        this.workerGroup.addWorker(worker);
    }

    public void dispatch() {
        while (true) {
            if (taskGroup == null || workerGroup == null) {
                sleep();
                continue;
            }

            IWorker worker = workerGroup.getFreeWorker();
            if (worker == null) {
                sleep();
                continue;
            }

            ITask task = taskGroup.getTask();
            if (task == null) {
                sleep();
                continue;
            }

            worker.arrangementWork(task);
            worker.doWork();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (java.lang.InterruptedException ex) {

        }
    }

}
