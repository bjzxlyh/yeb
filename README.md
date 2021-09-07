# YEB
本项目目的是实现中小型企业的在线办公系统，在线办公系统是一个用来管理日常的办公事务的一个系统，他能够管的内容有：日常的各种流程审批，新闻，通知，公告，文件信息，财务，人事，费用，资产，行政，项目，移动办公等等。它的作用就是通过软件的方式，方便管理，更加简单，更加扁平。更加高效，更加规范，能够提高整体的管理运营水平。基于前后端分离技术。前端基于Vue，后端基于Springboot+Mybatisplus等框架开发
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

# 相关技术点
## RabbitMQ
RabbitMQ 是一个消息中间件：它接受并转发消息。你可以把它当做一个快递站点，当你要发送一个包
裹时，你把你的包裹放到快递站，快递员最终会把你的快递送到收件人那里，按照这种逻辑 RabbitMQ 是
一个快递站，一个快递员帮你传递快件。RabbitMQ 与快递站的主要区别在于，它不处理快件而是接收，
存储和转发消息数据。

## JWT权限验证
在用户登录或注册成功后，为用户生成一个 token，并且将token存入Redis数据库中设置过期时间为30分钟，用户获取token之后，每次请求都需要携带 token。用户发送请求后，如果请求需要用户登录，服务会从请求头 token 获取 token，判断Redis中有没有该用户的token，如果有会更新在redis中的token时间重置为30分钟，再利用服务器的秘钥判断 token 是否被篡改，最后进行 token 的有效性验证，判断 token 是否过期或已经失效。 对于token失效处理:

用户注销 用户注销后会删除用户在Redis中的token信息
token过期 会去redis中查看是否有token信息，如果有生成新的token并且给前端返回状态码201并且返回新的token，新的token存入redis中替换掉旧token并设置30分钟过期。前端接收到以后在用户不知情的情况下修改请求头用新的token发送相同的请求到后台。

## Redis
Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。使用Redis时，会从数据库中查询菜单数据并设置到Redis中，此时再次查看发现Redis中已经有数据。再次查询会直接
查询Redis中数据。

## WebSocket
WebSocket 是 HTML5 开始提供的一种在单个 TCP 连接上进行全双工通讯的协议。WebSocket 使得客户端和服务器之间的数据交换变得更加简单，允许服务端主动向客户端推送数据。
在 WebSocket API 中，浏览器和服务器只需要完成一次握手，两者之间就直接可以创建持久性的连接，并进行双向数据传输。

## FastDFS
FastDFS是一个开源的轻量级分布式文件系统，它对文件进行管理，功能包括：文件存储、文件同步、文件访问（文件上传、文件下载）等，解决了大容量存储和负载均衡的问题。 特别适合以文件为载体的在线服务，如相册网站、视频网站等等。在头像更新功能时，使用FastDFS技术

## Nginx
Nginx 是高性能的 HTTP 和反向代理的服务器，处理高并发能力是十分强大的，能经受高负载的考验,有报告表明能支持高达 50,000 个并发连接数。在FastDFS模块中配置Nginx,配合使用



## 先创建数据库里面的表，再使用逆向工程创建各个POJO、Service等层

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/Yeb-generator/src/main/java");
        gc.setAuthor("xxx");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/yeb?useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("l46023424");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.xxxx")
                .setEntity("pojo")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/Yeb-server/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


## 全局异常处理

```java
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败");
        }
        return RespBean.error("数据库异常，操作失败");
    }
}
```
