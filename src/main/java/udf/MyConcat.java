package udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyConcat extends UDF {
    public String evaluate(String salary) {
        int sal = Integer.parseInt(salary);
        if (sal < 1000) return "Grade A";
        return "Grade C";
    }
}
