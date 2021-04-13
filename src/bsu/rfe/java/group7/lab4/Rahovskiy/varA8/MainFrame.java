package bsu.rfe.java.group7.lab4.Rahovskiy.varA8;


import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class MainFrame extends JFrame{
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private JMenuItem pauseMenuItem;
    private JMenuItem resumeMenuItem;
    private JMenuItem pauseMenuFastItem;
    private JMenuItem pauseMenuBigItem;
    private JMenuItem pauseMenuLittleItem;

    // Поле, по которому прыгают мячи
    private Field field = new Field();
    // Конструктор главного окна приложения
    public MainFrame() {
        super("Программирование и синхронизация потоков");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
        // Устанавливаем окно развёрнутым на весь экран
        setExtendedState(MAXIMIZED_BOTH);
        //меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu ballMenu = new JMenu("Мячи");
        Action addBallAction = new AbstractAction("Добавить мяч") {
            public void actionPerformed(ActionEvent event) {
                field.addBall();
                if (!pauseMenuItem.isEnabled() && !resumeMenuItem.isEnabled()
                        && !pauseMenuFastItem.isEnabled()) {
                    // Ни один из пунктов меню не являются
                    // доступными, сделать доступным паузу и паузу быстрых мячей доступными
                    pauseMenuItem.setEnabled(true);
                    pauseMenuFastItem.setEnabled(true);
                    pauseMenuBigItem.setEnabled(true);
                    pauseMenuLittleItem.setEnabled(true);

                }
            }
        };

        Action addThreeBallAction = new AbstractAction("Добавить 3 мяча") {
            public void actionPerformed(ActionEvent event) {
                field.addThreeBalls();
                if (!pauseMenuItem.isEnabled() && !resumeMenuItem.isEnabled()
                        && !pauseMenuFastItem.isEnabled()) {
                    // Ни один из пунктов меню не являются
                    // доступными, сделать доступным паузу и паузу быстрых мячей доступными
                    pauseMenuItem.setEnabled(true);
                    pauseMenuFastItem.setEnabled(true);
                    pauseMenuBigItem.setEnabled(true);
                    pauseMenuLittleItem.setEnabled(true);

                }
            }
        };
        menuBar.add(ballMenu);
        ballMenu.add(addBallAction);
        ballMenu.add(addThreeBallAction);
        JMenu controlMenu = new JMenu("Управление");
        menuBar.add(controlMenu);
        Action pauseAction = new AbstractAction("Приостановить движение"){
            public void actionPerformed(ActionEvent event) {
                field.pause();
                pauseMenuItem.setEnabled(false);
                resumeMenuItem.setEnabled(true);
                pauseMenuFastItem.setEnabled(false);
                pauseMenuBigItem.setEnabled(false);
                pauseMenuLittleItem.setEnabled(false);
            }
        };
        pauseMenuItem = controlMenu.add(pauseAction);
        pauseMenuItem.setEnabled(false);
        Action resumeAction = new AbstractAction("Возобновить движение") {
            public void actionPerformed(ActionEvent event) {
                field.resume();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(false);
                pauseMenuFastItem.setEnabled(true);
                pauseMenuBigItem.setEnabled(true);
                pauseMenuLittleItem.setEnabled(true);
            }
        };
        resumeMenuItem = controlMenu.add(resumeAction);
        resumeMenuItem.setEnabled(false);
        Action pauseFastAction = new AbstractAction("Приостановить быстрые мячи") {
            public void actionPerformed(ActionEvent event) {
                field.pauseFast();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(true);
                pauseMenuFastItem.setEnabled(false);
                pauseMenuBigItem.setEnabled(true);
                pauseMenuLittleItem.setEnabled(true);
            }
        };
        pauseMenuFastItem = controlMenu.add(pauseFastAction);
        pauseMenuFastItem.setEnabled(false);

        Action pauseBigAction = new AbstractAction("Приостановить большие мячи") {
            public void actionPerformed(ActionEvent event) {
                field.pauseBig();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(true);
                pauseMenuFastItem.setEnabled(true);
                pauseMenuBigItem.setEnabled(false);
                pauseMenuLittleItem.setEnabled(true);
            }
        };
        pauseMenuBigItem = controlMenu.add(pauseBigAction);
        pauseMenuBigItem.setEnabled(false);

        Action pauseLittleAction = new AbstractAction("Приостановить маленькие мячи") {
            public void actionPerformed(ActionEvent event) {
                field.pauseLittle();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(true);
                pauseMenuFastItem.setEnabled(true);
                pauseMenuBigItem.setEnabled(true);
                pauseMenuLittleItem.setEnabled(false);
            }
        };
        pauseMenuLittleItem = controlMenu.add(pauseLittleAction);
        pauseMenuLittleItem.setEnabled(false);

        // Добавить в центр граничной компоновки поле Field
        getContentPane().add(field, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
// Создать и сделать видимым главное окно приложения
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}