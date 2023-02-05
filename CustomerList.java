package ProjectCURD;

public class CustomerList {
    // 创建数组
        private Customer[] customers; // 用于保存客户对象的数组
        private int total = 0; // 记录已保存客户对象的数量

    // 构造器,用于初始化Customers 数组
    // totalCustomer： 指定customers 数组的最大空间
    public CustomerList(int totalCustomer) {
        // 动态初始化
        customers = new Customer[totalCustomer];


    }

    //添加用户
    // 用途：将参数customer 添加组中最后一个对象记录之后
    //参数： customer 指定要添加的客户对象
    // 返回：添加成功返回true; false 表示数组已经满了，无法添加
    public boolean addCustomer(Customer customer){
           if (total >= customers.length){
               return false;
           }else {
               customers[total] = customer;
               total++;
               return true;
           }
    }

    // 修改用户
    //用途：用参数customer 修改数组中由数组中由index 指定的对象
    // 参数: customer 指定替换的对象
    //       index 指定所替换对象在数组中的位置，从0 开始
    // 返回：替换成功返回true, false 表示索引无效，无法替代
    public boolean replaceCustomer(int index, Customer cust){
      // cust 新的对象
        if (index < 0 || index >= total)
            return false;

            customers[index] = cust;
            // 新的对象放到数组指定索引地方
            return true;

    }

    // 删除用户
    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total){
            return false;
        }else {
            for (int i = index; i < total - 1;i++){
                customers[i] = customers[i + 1];
                // i 最大取total -2, 数组中最后一位 total -1
            }
            customers[total - 1] = null; // 最后有数据的元素置空（null）
            total--; // 个数减一
            return true;
        }
    }

    // 获取所有的用户信息
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++){
            custs[i] = customers[i]; // 复制的是地址值
        }
        return custs;
    }



    // 获取指定索引的用户
    public Customer getCustomer(int index){
        if (index < 0 || index >= total){
            return null;
        }else {
            return customers[index];
        }
    }

    // 获取用户的个数
    public int getTotal(){
        return total;

    }



}
