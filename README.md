
## 一、项目展示

#### 1、项目整体浏览
<img width="2559" height="1599" alt="项目前端" src="https://github.com/user-attachments/assets/ed559274-a4b7-4070-96ff-5cbd0f91950d" />
-项目首页
<img width="2559" height="1548" alt="我的应用于精选应用" src="https://github.com/user-attachments/assets/275e72ef-7a26-4b79-916e-76fdb1736f84" />
-我的应用、精选应用展示

#### 2、ai对话界面
<img width="2559" height="1599" alt="生成应用" src="https://github.com/user-attachments/assets/b741922a-68b7-485e-93df-325976d72b55" />
-生成应用
<img width="1028" height="1003" alt="工具调用的前端显示" src="https://github.com/user-attachments/assets/361daf12-9e9c-49d7-acb7-0806b44aa2ea" />
-工具调用展示

#### 3、生成应用的实时展示与部署
<img width="2558" height="1265" alt="本地部署" src="https://github.com/user-attachments/assets/4625e4bb-da37-45bd-aade-03178d0b14b8" />
-本地部署
<img width="2558" height="1529" alt="本地部署到nginx服务器" src="https://github.com/user-attachments/assets/5ac4cb4d-3284-4ef8-b381-b8c19b15a21b" />
-本地部署查看

---

## 二、项目后端主要功能的架构分析

#### 1、调用大模型生成应用：
<img width="1358" height="1160" alt="调用大模型生成应用详细流程图" src="https://github.com/user-attachments/assets/13d77fe4-9e22-4e0a-b9e1-7f2fb1d0f184" />
采用门面、工厂多种设计模式；涉及到多种不同的AiService构建，专门用于流式生成、AI路由、结构化输出、根据不同类型采用不同大模型；采用了多种存储方式，ChatMemery的Redis缓存、ChatHistory的MySQL持久化保存、
利用caffeine本地缓存已实例化的智能体。

#### 2、应用部署
<img width="1339" height="906" alt="屏幕截图 2025-10-24 160742" src="https://github.com/user-attachments/assets/666f1c6c-6de6-4441-bd8b-53d56f0a3353" />
应用的实时展示是利用SpringBoot自带的Tpmcat服务器，在后端实现了一个静态资源服务接口，输入部署路径，直接返回相应文件；
部署功能是利用本地nginx直接映射部署目录，将应用资源部署到nginx服务器上。

#### 3、应用下载
<img width="1203" height="457" alt="屏幕截图 2025-10-24 161259" src="https://github.com/user-attachments/assets/cdb84b48-994d-4a61-8d9c-a95a46239108" />
利用hutool的ZipUtil 直接将过滤后的目录压缩到响应输出流。

#### 4、限流操作
<img width="1176" height="442" alt="屏幕截图 2025-10-24 161304" src="https://github.com/user-attachments/assets/2050969e-93bc-4189-993b-3ba898ff543b" />
利用Redisson上的RRatelimiter令牌桶算法结合自定义注解+AOP实现基于IP、用户、接口的三级限流策略。

#### 5、精选应用展示
<img width="672" height="651" alt="屏幕截图 2025-10-24 161714" src="https://github.com/user-attachments/assets/0d9b00a3-4a08-4824-a3a6-b22772c725f2" />

利用Redis旁路缓存策略，缓存访问频率高的页面，如精选应用，我的应用等。
