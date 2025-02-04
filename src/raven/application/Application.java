package raven.application;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import raven.application.form.LoginForm;
import raven.application.form.MainForm;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class Application extends javax.swing.JFrame {

    // Biến static để lưu trữ instance của ứng dụng
    private static Application app;

    // Biến để lưu trữ instance của MainForm và LoginForm
    private final MainForm mainForm;
    private final LoginForm loginForm;

    /**
     * Constructor của lớp Application
     */
    public Application() {
        // Khởi tạo các thành phần của giao diện
        initComponents();

        // Cài đặt kích thước và vị trí của cửa sổ
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);

        // Khởi tạo MainForm và LoginForm
        mainForm = new MainForm();
        loginForm = new LoginForm();

        // Thiết lập nội dung của cửa sổ là form đăng nhập
        setContentPane(loginForm);

        // Cài đặt JFrame cho Notifications
        
    }

    /**
     * Phương thức hiển thị form
     */
    public static void showForm(Component component) {
        // Áp dụng hướng component cho form
        component.applyComponentOrientation(app.getComponentOrientation());
        // Hiển thị form
        app.mainForm.showForm(component);
    }

    /**
     * Phương thức đăng nhập
     */
    public static void login() {
        // Hiển thị hiệu ứng khi đổi giao diện
        FlatAnimatedLafChange.showSnapshot();
        // Đặt nội dung cửa sổ là MainForm
        app.setContentPane(app.mainForm);
        // Áp dụng hướng component cho MainForm
        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
        // Thiết lập menu được chọn
        setSelectedMenu(0, 0);
        // Ẩn menu
        app.mainForm.hideMenu();
        // Cập nhật giao diện
        SwingUtilities.updateComponentTreeUI(app.mainForm);
        // Ẩn hiệu ứng khi đổi giao diện
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    /**
     * Phương thức đăng xuất
     */
    public static void logout() {
        // Hiển thị hiệu ứng khi đổi giao diện
        FlatAnimatedLafChange.showSnapshot();
        // Đặt nội dung cửa sổ là LoginForm
        app.setContentPane(app.loginForm);
        // Áp dụng hướng component cho LoginForm
        app.loginForm.applyComponentOrientation(app.getComponentOrientation());
        // Cập nhật giao diện
        SwingUtilities.updateComponentTreeUI(app.loginForm);
        // Ẩn hiệu ứng khi đổi giao diện
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    /**
     * Phương thức thiết lập menu được chọn
     */
    public static void setSelectedMenu(int index, int subIndex) {
        // Thiết lập menu được chọn trong MainForm
        app.mainForm.setSelectedMenu(index, subIndex);
    }

    // Phương thức tạo ra các thành phần của giao diện
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Phương thức main để chạy ứng dụng
    public static void main(String args[]) {
        // Cài đặt font chữ
        FlatRobotoFont.install();
        // Đăng ký theme tùy chỉnh
        FlatLaf.registerCustomDefaultsSource("raven.theme");
        // Cài đặt font mặc định
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        // Thiết lập giao diện MacDark
        FlatMacDarkLaf.setup();
        
        // Chạy ứng dụng trong Event Dispatch Thread
        java.awt.EventQueue.invokeLater(() -> {
            // Khởi tạo ứng dụng
            app = new Application();
            // Hiển thị cửa sổ ứng dụng
            app.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
