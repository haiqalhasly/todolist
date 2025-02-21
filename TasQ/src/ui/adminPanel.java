package TasQ.src.ui;

import TasQ.src.model.Task;
import TasQ.src.service.taskController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminPanel extends JFrame {
    private taskController taskController = new TasQ.src.service.taskController();
    private DefaultListModel<String> taskListModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(taskListModel);
    private JTextField titleField = new JTextField(15);
    private JTextField descriptionField = new JTextField(15);
    private JTextField expField = new JTextField(5);
    private JButton addButton = new JButton("Add Task");
    private JButton deleteButton = new JButton("Delete Task");

    public adminPanel() {
        setTitle("TasQ - Admin Panel");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Description:"));
        add(descriptionField);
        add(new JLabel("EXP:"));
        add(expField);
        add(addButton);
        add(deleteButton);
        add(new JScrollPane(taskList));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        updateTaskList();
        setVisible(true);
    }

    private void addTask() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        int exp = Integer.parseInt(expField.getText());
        taskController.addTask(title,description,exp);
        updateTaskList();
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0) {
            taskController.deleteTask(selectedIndex + 1);
            updateTaskList();
        }
    }

    private void updateTaskList() {
        taskListModel.clear();
        for (Task task : taskController.getAllTasks()) {
            taskListModel.addElement(task.getTitle() + " - " + task.getExp() + " EXP");
        }
    }

    public static void main(String[] args) {
        new adminPanel();
    }
}
