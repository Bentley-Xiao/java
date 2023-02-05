package ProjectCURD;

public class CustomerView {
    private CustomerList Customers = new CustomerList(10);

    public CustomerView(){
        Customer cust = new Customer("张三",'男',30,"188611111","abc@qq.com");
        Customers.addCustomer(cust);
    }

    public void enterMainMenu() {

        // do while 语法
        // do {
        //    statement(s)
        //  } while (express);

        boolean loopFlag = true;
        do {

            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退      出\n");
            System.out.print("                   请选择(1-5)：");

            // 获取键盘数字
            char key = CMUtility.readMenuSelection();
            System.out.println();

            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出（Y/N）");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y') {
                        loopFlag = false;
                        break;
                    }
            }
        }while (loopFlag);

    }

    // 添加客户
    public void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        // readString 限制字符串长度
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        // readChar 读取字符限制长度
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);

        // 将数据封装到对象中
        Customer cust = new Customer(name,gender,age,phone,email);
        boolean flag = Customers.addCustomer(cust);
        if (flag){
            System.out.println("---------------------添加完成---------------------");
        }else {
            System.out.println("----------------记录已满,无法添加-----------------");
        }


    }

    public void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");

        // number 从屏幕输入获取
        int number = 0;
        Customer cust = null;

        for(;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }

            cust = Customers.getCustomer(number -1);
            if (cust == null){
                System.out.println("无法找到指定客户！");
            }else { // 找到了相应编号的客户
                break;
            }
        }

        // 修改客户信息
        System.out.print("姓名（" + cust.getName() + "):");
        String name = CMUtility.readString(4,cust.getName());
        System.out.print("性别（" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄（" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话（" + cust.getPhone() + "):");
        String phone = CMUtility.readString(15,cust.getPhone());
        System.out.print("邮箱（" + cust.getEmail() + "):");
        String email = CMUtility.readString(15,cust.getEmail());

        // 忘记将属性放到新的对象中
        cust = new Customer(name, gender, age, phone, email);
        boolean flag = Customers.replaceCustomer(number -1,cust);
        if(flag){
            System.out.println("---------------------修改完成---------------------");
        }else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }



    }

    public void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");

        // number 从屏幕输入获取
        int number;
        Customer cust;

        for(;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }

            cust = Customers.getCustomer(number -1);
            if (cust == null){
                System.out.println("无法找到指定客户！");
            }else { // 找到了相应编号的客户
                break;
            }
        }

        System.out.print("确认是否删除(Y/N)：");
        char yn = CMUtility.readConfirmSelection();
        if (yn == 'N'){
            return;
        }
        boolean flag = Customers.deleteCustomer(number -1);
        if(flag){
            System.out.println("---------------------删除完成---------------------");
        }else {
            System.out.println("----------无法找到指定客户,删除失败--------------");
        }


    }

    public void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] cust =Customers.getAllCustomers();
        if (cust.length == 0){
            System.out.println("没有客户记录！");
        }else{
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < cust.length;i++){
                System.out.println((i+1) + "\t" + cust[i].getName() + "\t" + cust[i].getGender() + "\t" + cust[i].getAge() + "\t" + cust[i].getPhone() + "\t" + cust[i].getEmail() + "\t");
            }
        }
    }


    public static void main(String[] args) {
        CustomerView cView = new CustomerView();
        cView.enterMainMenu();
    }

}

// 教训： 修改代码需要重新执行才能生效
