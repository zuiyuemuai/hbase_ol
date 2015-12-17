package cn.netease.hbase.online.DB;

import org.apache.hadoop.fs.Hdfs;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseTest {

	public static void main(String[] agrs) {
		
		try {
			
			String tablename = "testtables";
			String[] familys = { "personal", "professional" };
			
			HBaseConnector connector = new HBaseConnector("db-43.photo.163.org","2181");
			HTableDescriptor[] htds = connector.getAllTableNameList();
			for(HTableDescriptor t:htds)
			{
				System.out.println(t.getNameAsString());
			}
//			connector.creatTable(tablename, familys);
			
//			Put p = new Put(Bytes.toBytes("employee1"));
//			p.add(Bytes.toBytes("personal"), Bytes.toBytes("name"),
//					Bytes.toBytes("karthy"));
//			p.add(Bytes.toBytes("personal"), Bytes.toBytes("city"),
//					Bytes.toBytes("atlanta"));
//			p.add(Bytes.toBytes("professional"), Bytes.toBytes("designation"),
//					Bytes.toBytes("developer"));
//			p.add(Bytes.toBytes("professional"), Bytes.toBytes("salary"),
//					Bytes.toBytes("100000"));
//			connector.addRecord(tablename, p);
//			
//			p = new Put(Bytes.toBytes("employee1"));
//			p.add(Bytes.toBytes("personal"), Bytes.toBytes("name"),
//					Bytes.toBytes("vinodh"));
//			p.add(Bytes.toBytes("personal"), Bytes.toBytes("city"),
//					Bytes.toBytes("chicago"));
//			p.add(Bytes.toBytes("professional"), Bytes.toBytes("designation"),
//					Bytes.toBytes("developer"));
//			p.add(Bytes.toBytes("professional"), Bytes.toBytes("salary"),
//					Bytes.toBytes("100000"));
//			connector.addRecord(tablename, p);
//			
//			connector.getOneRecord(tablename, "employee1");

			connector.scan(tablename);

			Filter filter = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL, new BinaryComparator("emp".getBytes()));
			connector.scan(tablename, filter);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
