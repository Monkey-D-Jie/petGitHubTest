package com.server;

import com.esvo.impl.TempVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("esServer")
public class EsServer {
	@Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
	
	@PostConstruct
	private void init(){
		if (!elasticsearchTemplate.indexExists(TempVo.indexName)) {
			// /注入时调用,当这个索引不存在,则创建索引
            elasticsearchTemplate.createIndex(TempVo.indexName);
            System.out.println("init方法成功执行了，已经！");
        }
	}
	
	public void delete(String id){
		elasticsearchTemplate.delete(TempVo.class,id);
	}
	
	public void update(Map<String,Object> map){
		TempVo t = new TempVo();
		//t.setId(String.valueOf(map.get("id")));
		t.setAge(6666L);
		t.setName(String.valueOf(map.get("name")));
		IndexQuery iq = new IndexQueryBuilder().withObject(t).build();
		ArrayList<IndexQuery> inserts = new ArrayList<IndexQuery>();
		inserts.add(iq);
		elasticsearchTemplate.bulkIndex(inserts);
	}
	public void insert(Map<String,Object> map){
		TempVo t = new TempVo();
		//t.setId(String.valueOf(map.get("id")));
		t.setAge(Integer.parseInt(String.valueOf(map.get("age"))));
		t.setName(String.valueOf(map.get("name")));
		IndexQuery iq = new IndexQueryBuilder().withObject(t).build();
		ArrayList<IndexQuery> inserts = new ArrayList<IndexQuery>();
		inserts.add(iq);
		elasticsearchTemplate.bulkIndex(inserts);
	}

	public TempVo query(String name){
		Criteria c = new Criteria();
		c.and(Criteria.where("name").is(name));
		CriteriaQuery cq = new CriteriaQuery(c);
		List<TempVo> ret = elasticsearchTemplate.queryForList(cq,TempVo.class);
		return ret.get(0);
	}


}
