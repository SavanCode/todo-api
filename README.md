# Todo API

一个基于 Spring Boot 的待办事项 RESTful API 服务。

## 技术栈

- Java 8+
- Spring Boot 2.7.x
- Spring Data JPA
- MySQL
- Maven
- Lombok

## 功能特性

- 待办事项的增删改查
- 按完成状态筛选待办事项
- 参数验证
- 统一异常处理
- RESTful API 设计

## API 文档

### 获取所有待办事项
```http
GET /api/todos
```

### 获取单个待办事项
```http
GET /api/todos/{id}
```

### 创建待办事项
```http
POST /api/todos
Content-Type: application/json

{
    "title": "完成项目",
    "description": "完成Todo API项目开发"
}
```

### 更新待办事项
```http
PUT /api/todos/{id}
Content-Type: application/json

{
    "title": "更新后的标题",
    "description": "更新后的描述",
    "completed": true
}
```

### 删除待办事项
```http
DELETE /api/todos/{id}
```

### 按状态筛选待办事项
```http
GET /api/todos/status?completed=true
```

## 项目结构

```
src/main/java/com/example/todoapi/
├── controller/          # 控制器层
├── service/            # 服务层
├── repository/         # 数据访问层
├── entity/            # 实体类
├── dto/               # 数据传输对象
└── exception/         # 异常处理
```

## 运行项目

1. 克隆项目
```bash
git clone [项目地址]
```

2. 配置数据库
编辑 `application.properties` 文件，配置数据库连接信息：
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. 构建项目
```bash
mvn clean install
```

4. 运行项目
```bash
mvn spring-boot:run
```

## 错误处理

API 使用统一的错误响应格式：

```json
{
    "status": 400,
    "message": "错误信息",
    "timestamp": "2024-01-01T12:00:00"
}
```

验证错误响应格式：

```json
{
    "status": 400,
    "message": "Validation failed",
    "errors": {
        "fieldName": "错误信息"
    },
    "timestamp": "2024-01-01T12:00:00"
}
```

## 测试功能

启动应用后，可以用以下方式测试：

使用curl命令：
```json
# 创建TODO
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"学习Spring Boot","description":"完成TODO List项目"}'

# 获取所有TODO
curl http://localhost:8080/api/todos

# 更新TODO状态
curl -X PUT http://localhost:8080/api/todos/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"学习Spring Boot","description":"完成TODO List项目","completed":true}'
```

## H2 数据库

访问H2控制台：

```json
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
用户名: sa
密码: （空）
```

## 许可证

MIT License 