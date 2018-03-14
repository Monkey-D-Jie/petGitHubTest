package esTest;

import com.esvo.impl.TempVo;
import com.server.EsServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wjie
 * @date: 2018/3/9 0009
 * @time: 13:18
 * To change this template use File | Settings | File and Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-config.xml"})
public class EsTest {
    @Autowired
    private EsServer esServer;

    @Test
    public void insertTest(){
        Map<String,Object> map = new HashMap<String,Object>(8);
        map.put("id",8888);
        map.put("age",28);
        map.put("name","黑豹03.12--新来的");
        System.out.println("插入的数据为"+map.toString());
        this.esServer.insert(map);
    }

    @Test
    public void queryTest(){
        String name = "老王测试-数据更改成功";
        TempVo tempVo = this.esServer.query(name);
        System.out.println("查询条件,name:"+name);
        System.out.println("查询到的信息为:"+tempVo.toString());
    }
    @Test
    public void updateTest(){
        Map<String,Object> map = new HashMap<String,Object>(8);
        map.put("id",666);
        map.put("age",33);
        map.put("name","老王测试-数据更改成功");
        System.out.println("更新的数据为"+map.toString());
        this.esServer.update(map);
    }
    @Test
    public void deleteTest(){
        String id = "77777777";
        this.esServer.delete(id);
    }

    @Test
    public void splitQueryTest(){
        String  content = "中华人民共和国";
//        ESTools.client.admin().indices()
//                .prepareAnalyze(content)//内容
//                .setAnalyzer("ik")//指定分词器
//                .execute().actionGet();//执行
//        List<AnalyzeResponse.AnalyzeToken> tokens = response.getTokens();
        //String result = JSONArray.fromObject(tokens).toString();
        //System.out.println(result);
    }


}
