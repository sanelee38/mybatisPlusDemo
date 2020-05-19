
## MyBatis Plus



### Mybatis Plus快速上手

国产框架



1. 创建springboot工程

2. application.yml

   ```yml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8
       username: root
       password: root
   mybatis-plus:
     configuration:
       log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
   ```

   

3. 导入Mybatis Plus的依赖

   ```xml
   <dependency>
       <groupId>com.baomidou</groupId>
       <artifactId>mybatis-plus-boot-starter</artifactId>
       <version>3.3.1.tmp</version>
   </dependency>
   ```

4. 创建实体类

   ```java
   package com.sanelee.mybatisplus.entity;
   
   import lombok.Data;
   
   /**
    * @author sanelee
    * @date 2020/5/18
    **/
   @Data
   public class User {
       private Integer id;
       private String name;
       private Integer age;
   }
   ```

5. 创建Mapper接口

   ```java
   public interface UserMapper extends BaseMapper<User> {
   }
   ```

6. 测试

   ```java
   @SpringBootTest
   class UserMapperTest {
       @Autowired
       private UserMapper mapper;
   
       @Test
       void test(){
           mapper.selectList(null).forEach(System.out::println);
       }
   
   }
   ```

   

#### 常用注解

>@TableName（value=“”）
>
>映射数据库表名

>@TableId
>
>设置主键映射，
>
>value映射主键字段的名字，
>
>type设置主键类型，主键的生成策略
>
>```java
>AUTO(0),
>NONE(1),
>INPUT(2),
>ASSIGN_ID(3),
>ASSIGN_UUID(4),
>/** @deprecated */
>@Deprecated
>ID_WORKER(3),
>/** @deprecated */
>@Deprecated
>ID_WORKER_STR(3),
>/** @deprecated */
>@Deprecated
>UUID(4);
>```
>
>| 值          | 描述                                       |
>| ----------- | ------------------------------------------ |
>| AUTO        | 数据库自增                                 |
>| NONE        | Mybatis Plus  set主键，雪花算法实现        |
>| INPUT       | 需要开发者手动赋值                         |
>| ASSIGN_ID   | Mybatis Plus 分配ID、Long、Integer、String |
>| ASSIGN_UUID | 分配UUID，String                           |
>
>INPUT如果开发者没有手动赋值，则数据库通过自增的方式给主键赋值，如果开发者手动赋值，则存入该值
>
>AUTO 默认数据库自增，开发者无需赋值
>
>ASSIGN_ID  Mybatis Plus 自动赋值，雪花算法
>
>ASSIGN_UUID 主键的数据类型必须是String，自动生成UUID进行赋值

 >@TableField(value =“”)
 >
 >映射非主键字段，
 >
 >value映射字段名
 >
 >exist表示是否为数据库字段
 >
 >select表示是否查询该字段
 >
 >fill表示是否自动填充，将对象存入数据库的时候，由Mybatis Plus自动给某些字段赋值，create_time、update_time
 >
 >1. 给表添加create_time、update_time字段
 >
 >2. 实体类中添加成员变量
 >
 >  ```java
 >  @Data
 >  @TableName(value = "user")
 >  public class User {
 >      @TableId
 >      private String id;
 >      @TableField(value = "name",select = false)
 >      private String title;
 >      private Integer age;
 >      @TableField(exist = false)
 >      private String gender;
 >      @TableField(fill = FieldFill.INSERT)
 >      private Date createTime;
 >      @TableField(fill = FieldFill.INSERT_UPDATE)
 >      private Date updateTime;
 >  }
 >  ```
 >
 >3. 创建自动填充处理器
 >
 >  ```java
 >  @Component
 >  public class MyMetaObjectHandler implements MetaObjectHandler {
 >  
 >      @Override
 >      public void insertFill(MetaObject metaObject) {
 >          this.setFieldValByName("createTime",new Date(),metaObject);
 >          this.setFieldValByName("updateTime",new Date(),metaObject);
 >          
 >      }
 >  
 >      @Override
 >      public void updateFill(MetaObject metaObject) {
 >          this.setFieldValByName("updateTime",new Date(),metaObject);
 >      }
 >  }
 >  ```
 >
 >  

>@Version
>
>标记乐观锁，通过一个version字段来保证数据的安全性，当修改数据的时候，会以version作为条件，当条件成立的时候才会修改成功。
>
>1. 数据库表添加version字段，默认值为1
>2. 实体类添加version成员变量，并且添加@Version 
>3. 注册配置类

>@EnumValue
>
>通用的枚举类注解，将数据库的字段映射成实体类的枚举类型成员变量

>@TableLogic
>
>映射逻辑删除
>
>1. 数据表添加delete字段
>
>2. 实体类添加注解
>
>3. application.yml添加配置
>
>   ```yml
>   mybatis-plus:
>     global-config:
>       db-config:
>         logic-delete-value: 1
>         logic-not-delete-value: 0
>   ```
>
>   

#### 查询

```java
    @Test
    void select(){
        //不加任何条件直接全部查询
//        mapper.selectList(null);
//        QueryWrapper wrapper = new QueryWrapper();
//        Map<String ,Object> map = new HashMap<>();
//        map.put("name","哈登");
//        map.put("age","2");
//        wrapper.allEq(map);
        //小于
//        wrapper.lt("age",3);
        //大于
//        wrapper.gt("age",2);
        //不等于
//        wrapper.ne("name","哈登");
        //大于等于
//        wrapper.ge("age",2);
        //模糊查询
        /**
         * likeLeft == like "%少"
         * likeRight == like "少%"
         */
//        wrapper.like("name","少");
        //联合查询inSql
//        wrapper.inSql("id","select id from user where id <38");
//        wrapper.inSql("age","select age from user where age >3");
        //排序
//        wrapper.orderByAsc("age");
//        wrapper.having("id>8");
//        mapper.selectList(wrapper).forEach(System.out::println);
        //多个Id查询
//        mapper.selectBatchIds(Arrays.asList(1,13,35)).forEach(System.out::println);
        //Map只能做等值判断，逻辑判断需要用wrapper
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",37);
//        mapper.selectByMap(map).forEach(System.out::println);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",13);
//        System.out.println(mapper.selectCount(wrapper));

        //将查询的结果集封装到Map中
//        mapper.selectMaps(wrapper).forEach(System.out::println);

        //分页查询
//        Page<User> page = new Page<>(2,2);
//        Page<User> result = mapper.selectPage(page, null);
//        System.out.println(result.getSize());
//        System.out.println(result.getTotal());
//        result.getRecords().forEach(System.out::println);

//        Page<Map<String,Object>> page = new Page<>(1,2);
//        mapper.selectMapsPage(page,null).getRecords().forEach(System.out::println);
        //仅仅查询id
//        mapper.selectObjs(null).forEach(System.out::println);
        //查询单个数据
        System.out.println(mapper.selectOne(wrapper));
```

#### 自定义SQL（多表关联查询）

```java
public interface UserMapper extends BaseMapper<User> {
    @Select("select p.*,u.name userName from product p,user u where p.user_id=u.id and u.id = #{id};")
    List<ProductVO> productList(Integer id);
}
#############################################
    
        @Test
    void product(){
        mapper.productList(13).forEach(System.out::println);
    }
```



#### 添加

```java
    @Test
    void save(){
        User user = new User();
        user.setId(35L);
        user.setTitle("杜少");
        user.setAge(1);
        mapper.insert(user);
        System.out.println(user);
    }
```



#### 删除

```
 @Test
    void delete(){
//        mapper.deleteById(1);
//        mapper.deleteBatchIds(Arrays.asList(13,37));
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("age",1);
//        mapper.delete(wrapper);
        Map<String,Object> map =new HashMap<>();
        map.put("id",23);
        mapper.deleteByMap(map);
    }
```



#### 修改

```java
@Test
    void update(){
//        User user = mapper.selectById(13L);
//        user.setTitle("哈登");
//        user.setAge(3);
//
//
////        User user1 = mapper.selectById(13L);
////        user1.setTitle("哈登2");
////        user.setAge(AgeEnum.THREE);
////
////        mapper.updateById(user1);
//        mapper.updateById(user);
        User user = mapper.selectById(36L);
        user.setTitle("斯科拉");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",2);
        mapper.update(null,wrapper);
    }
```



#### MybatisPlus 自动生成

根据数据表自动生成实体类、Mapper、Service、ServiceImpl、Controller

1. pom.xml导入Mybatis Plus Generate依赖

   ```yml
   <dependency>
               <groupId>com.baomidou</groupId>
               <artifactId>mybatis-plus-generator</artifactId>
               <version>3.3.1.tmp</version>
           </dependency>
   <dependency>
               <groupId>org.apache.velocity</groupId>
               <artifactId>velocity</artifactId>
               <version>1.7</version>
   </dependency>
   <dependency>
       <groupId>org.apache.velocity</groupId>
       <artifactId>velocity-engine-core</artifactId>
       <version>2.2</version>
   </dependency>
   ```

   velocity（默认）、Freemarker、Beetl

2. 启动类

   ```java
   package com.sanelee.mybatisplus;
   
   import com.baomidou.mybatisplus.annotation.DbType;
   import com.baomidou.mybatisplus.generator.AutoGenerator;
   import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
   import com.baomidou.mybatisplus.generator.config.GlobalConfig;
   import com.baomidou.mybatisplus.generator.config.PackageConfig;
   import com.baomidou.mybatisplus.generator.config.StrategyConfig;
   import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
   
   /**
    * @author sanelee
    * @date 2020/5/19
    **/
   public class Main {
       public static void main(String[] args) {
           //创建generator对象
           AutoGenerator autoGenerator = new AutoGenerator();
           //数据源
           DataSourceConfig dataSourceConfig = new DataSourceConfig();
           dataSourceConfig.setDbType(DbType.MYSQL);
           dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/movie?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8");
           dataSourceConfig.setUsername("root");
           dataSourceConfig.setPassword("root");
           dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
           autoGenerator.setDataSource(dataSourceConfig);
           //全局配置
           GlobalConfig globalConfig = new GlobalConfig();
           globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
           globalConfig.setOpen(false);
           globalConfig.setAuthor("sanelee");
           globalConfig.setServiceName("%sService");
           autoGenerator.setGlobalConfig(globalConfig);
           //包信息
           PackageConfig packageConfig = new PackageConfig();
           packageConfig.setParent("com.sanelee.mybatisplus");
           packageConfig.setModuleName("generator");
           packageConfig.setController("controller");
           packageConfig.setService("service");
           packageConfig.setServiceImpl("service.impl");
           packageConfig.setMapper("mapper");
           packageConfig.setEntity("entity");
           autoGenerator.setPackageInfo(packageConfig);
           //配置策略
           StrategyConfig strategyConfig = new StrategyConfig();
                   //生成部份表模板
   //        strategyConfig.setInclude("movie","person");
               //实体类配置Lombok
           strategyConfig.setEntityLombokModel(true);
               //下划线转驼峰
           strategyConfig.setNaming(NamingStrategy.underline_to_camel);
           strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
           autoGenerator.setStrategy(strategyConfig);
   
           autoGenerator.execute();//执行
   
   
       }
   }
   
   ```

   



#### Springboot + MybatisPlus打包应用，直接发布云
