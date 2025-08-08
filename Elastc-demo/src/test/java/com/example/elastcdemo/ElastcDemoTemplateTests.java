package com.example.elastcdemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.example.elastcdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ElastcDemoTemplateTests {

    /**
     * 基于 ElasticsearchClient 操作
     */
    @Autowired
    private ElasticsearchClient client;

    // 示例索引名称
    private static final String INDEX_NAME = "users";

    @Test
    void contextLoads() {
    }


    /**
     * 1. 创建索引（如果不存在）
     */
    @Test
    public void createIndex() throws IOException {
        // 如果索引已存在，先删除（可选）
        try {
            client.indices().delete(d -> d.index(INDEX_NAME));
        } catch (Exception  e) {
            // 索引不存在时忽略异常
        }

        // 创建索引（这里使用简单设置，实际项目中可以添加分片、副本、映射等配置）
        client.indices().create(c -> c.index(INDEX_NAME));
        System.out.println("索引创建成功: " + INDEX_NAME);
    }

    /**
     * 2. 添加文档
     */
    @Test
    public void addDocument() throws IOException {
        // 准备文档数据
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", "张三");
        jsonMap.put("age", 30);
        jsonMap.put("email", "zhangsan@example.com");

        // 添加文档
        IndexResponse response = client.index(i -> i
                .index(INDEX_NAME)
                .id("1") // 指定文档ID（可选，不指定则自动生成）
                .document(jsonMap)
        );

        System.out.println("文档添加成功，ID: " + response.id());
    }

    @Test
    public void addOrUpdateUser() throws IOException {
        User user = new User();
        user.setId("2");
        user.setUsername("张三1");
        user.setAddress("北京市");
        user.setAge(30);
        user.setGender("男");

        // 如果ID已存在则更新，不存在则新增
        IndexResponse response = client.index(i -> i
                .index("users")
                .id(user.getId())
                .document(user) // 直接传入对象，客户端会自动序列化
        );
        System.out.println("操作结果: " + response.result().name());
    }

    @Test
    public void bulkAddUsers() throws IOException {
        List<User> users = List.of(
                new User("3", "李四", "上海市", 25, "男"),
                new User("4", "王芳", "广州市", 28, "女")
        );

        BulkRequest.Builder br = new BulkRequest.Builder();
        for (User user : users) {
            br.operations(op -> op.index(idx -> idx
                    .index("users")
                    .id(user.getId())
                    .document(user)
            ));
        }

        BulkResponse response = client.bulk(br.build());
        System.out.println("批量操作完成，错误数: " + response.errors());
    }

    /**
     * 3. 查询文档
     */
    @Test
    public void getDocument() throws IOException {
        // 根据ID查询文档
        GetResponse<Object> response = client.get(g -> g
                        .index(INDEX_NAME)
                        .id("1"),
                Object.class // 指定返回类型，这里用Object，实际项目中可以用具体类
        );

        if (response.found()) {
            System.out.println("查询到的文档: " + response.source());
        } else {
            System.out.println("文档未找到");
        }
    }

    /**
     * 4. 更新文档
     */
    @Test
    public void updateDocument() throws IOException {
        // 准备更新数据
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("age", 31); // 更新年龄

        // 更新文档
        UpdateResponse<Object> response = client.update(u -> u
                        .index(INDEX_NAME)
                        .id("1")
                        .doc(jsonMap), // 更新内容
                Object.class
        );

        System.out.println("文档更新成功，版本: " + response.version());
    }

    /**
     * 5. 删除文档
     */
    @Test
    public void deleteDocument() throws IOException {
        // 删除文档
        DeleteResponse response = client.delete(d -> d
                .index(INDEX_NAME)
                .id("1")
        );

        if (response.result().name().equals("Deleted")) {
            System.out.println("文档删除成功");
        } else {
            System.out.println("文档删除失败");
        }
    }

    /**
     * 6. 搜索文档（简单示例）
     */
    @Test
    public void searchDocuments() throws IOException {
        // 1. 构建 matchAll 查询（必须传入 MatchAllQuery 对象）
        Query matchAllQuery = Query.of(q -> q
                .matchAll(new MatchAllQuery.Builder().build()) // 明确构建 MatchAllQuery 对象
        );

        // 2. 构建搜索请求
        SearchRequest searchRequest = SearchRequest.of(s -> s
                .index(INDEX_NAME)
                .query(matchAllQuery)
        );

        // 3. 执行查询
        SearchResponse<Object> response = client.search(searchRequest, Object.class);

        // 4. 打印结果
        System.out.println("查询到 " + response.hits().hits().size() + " 条文档");
        for (Hit<Object> hit : response.hits().hits()) {
            System.out.println("文档ID: " + hit.id());
        }
    }

}
