package ru.job4j.search;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;

        if(tasks.size()==0){
            this.tasks.add(index, task);
        }else{
            for(index = 0 ;index < tasks.size();index++)
                if(task.getPriority() < tasks.get(0).getPriority()){
                    index=0;
                    tasks.add(index, task);

                }else{
                    index++;
                    tasks.add(index, task);


                }
            }
        }


    public Task take() {
        return tasks.poll();
    }
}
