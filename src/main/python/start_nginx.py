import subprocess
import os

def start_nginx():
    # Nginx 可执行文件路径
    nginx_path = r"D:\Devlope\nginx-1.18.0\nginx-1.18.0\nginx.exe"

    # 检查路径是否存在
    if not os.path.exists(nginx_path):
        print(f"错误：未找到 Nginx 可执行文件，路径：{nginx_path}")
        return False

    try:
        # 启动 Nginx（不显示命令行窗口）
        subprocess.Popen([nginx_path], creationflags=subprocess.CREATE_NO_WINDOW)
        print("Nginx 已启动！")
        return True
    except Exception as e:
        print(f"启动失败：{e}")
        return False

if __name__ == "__main__":
    start_nginx()