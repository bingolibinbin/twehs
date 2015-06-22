/*
 * package com.twehs.service.menu.impl;
 * 
 * import java.sql.SQLException;
 * 
 * import antlr.collections.List;
 * 
 * import com.twehs.pojo.Type; import
 * com.twehs.service.menu.impl.TypeServiceImpl; import
 * com.twehs.utils.pubutil.Page; import
 * com.twehs.utils.system.SqlMapClientFactory; import
 * com.twehs.dao.power.TypeDAO; import com.twehs.dao.power.impl.TypeDAOImpl;
 * 
 * 
 * import junit.framework.TestCase;
 * 
 * 
 * public class TypeTest extends TestCase { public TypeServiceImpl typeService;
 * //瀹炰緥鍖栦竴涓猻ervice杩涜娴嬭瘯锛�
 * 
 * public TypeTest(String name) { super(name); }
 * 
 * protected void setUp() throws Exception { super.setUp(); typeService = new
 * TypeServiceImpl(); TypeDAOImpl TypeDAO = new TypeDAOImpl();
 * TypeDAO.setSqlMapClient(SqlMapClientFactory.getSqlMapClient());
 * typeService.setTypeDAO(TypeDAO); } //杩欓噷鍦ㄥ伐鍘傛ā寮忎笅瀵箄serService杩涜娉ㄥ唽锛�
 * 
 * protected void tearDown() throws Exception { super.tearDown(); }
 * 
 * 
 * public void TestfindPageTtype() throws SQLException{ // TODO Auto-generated
 * method stub Page page = new Page(); page .setStart(1); page.setLimit(2);
 * 
 * List list = typeService.findPageTtype(page);
 * 
 * 
 * System.out.println("显示typename:"+Type.getTypename());
 * //测试结果，这个findPageTtype没执行
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * }
 */