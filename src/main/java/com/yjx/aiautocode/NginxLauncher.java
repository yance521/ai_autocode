package com.yjx.aiautocode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NginxLauncher {

    public static void main(String[] args) {
        // 默认 Nginx 路径（修改为你的实际路径）
        String nginxPath = "D:\\Devlope\\nginx-1.18.0\\nginx-1.18.0\\nginx.exe";

        // 自定义参数（示例：["-p", "D:\\nginx", "-c", "conf\\nginx.conf"]）
        List<String> customArgs = new ArrayList<>();
        customArgs.add("-p");
        customArgs.add("D:\\Devlope\\nginx-1.18.0\\nginx-1.18.0"); // Nginx 工作目录
        customArgs.add("-c");
        customArgs.add("conf\\nginx.conf"); // 指定配置文件

        // 启动 Nginx
        boolean success = startNginx(nginxPath, customArgs);

        // 返回退出码（0=成功，1=失败）
        System.exit(success ? 0 : 1);
    }

    /**
     * 启动 Nginx
     * @param nginxPath   Nginx 可执行文件路径
     * @param customArgs  自定义命令行参数
     * @return 是否启动成功
     */
    public static boolean startNginx(String nginxPath, List<String> customArgs) {
        // 检查 Nginx 是否存在
        File nginxFile = new File(nginxPath);
        if (!nginxFile.exists()) {
            System.err.println("[错误] 未找到 Nginx，路径: " + nginxPath);
            return false;
        }

        // 构造完整命令
        List<String> command = new ArrayList<>();
        command.add(nginxPath);
        command.addAll(customArgs);

        try {
            // 使用 ProcessBuilder 启动进程（支持隐藏窗口）
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true); // 合并错误流和输出流

            // 在 Windows 上隐藏命令行窗口
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                processBuilder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
                processBuilder.redirectError(ProcessBuilder.Redirect.DISCARD);
            }

            // 启动进程
            Process process = processBuilder.start();
            System.out.println("[成功] Nginx 已启动！命令: " + String.join(" ", command));

            // 非阻塞式启动（如需等待进程结束，可调用 process.waitFor()）
            return true;
        } catch (IOException e) {
            System.err.println("[错误] 启动 Nginx 失败: " + e.getMessage());
            return false;
        }
    }
}