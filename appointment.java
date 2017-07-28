public static void main( String[] args ) throws InterruptedException {
      String local_chromedriver_addr = "";
      System.setProperty("webdriver.chrome.driver", local_chromedriver_addr);
      
      WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://ibook/index.do");
        driver.manage().window().maximize();

        //Thread.sleep(2000);

        
        driver.switchTo().frame("bottomFrame");
        driver.switchTo().frame("mainFrame");
        Select select = new Select(driver.findElement(By.name("apptDetails.apptType")));
        
        select.selectByVisibleText("Apply");
        
        WebElement fin = driver.findElement(By.name("apptDetails.identifier1"));
        fin.sendKeys(""); //fin
        WebElement no = driver.findElement(By.name("apptDetails.identifier2"));
        no.sendKeys(""); // no of person
        WebElement cn = driver.findElement(By.name("apptDetails.identifier3"));
        cn.sendKeys(""); // phone

        WebElement sb = driver.findElement(By.name("Submit"));
        sb.click();
        
        List<WebElement> next;
        
        Date today = new Date();
        int month = today.getMonth() + 1;
        
        System.out.println("Current Month: "+ month);
     
        
        List<WebElement> list = driver.findElements(By.className("cal_AS"));
        if (list.size() == 0) {
          System.out.println("continue fucking next month");
          next = driver.findElements(By.linkText("<Next>"));
          next.get(0).click();
        } else {
          System.out.println("go go go go");
        }
        
        month++;
        System.out.println("Month: "+ month);
        list = driver.findElements(By.className("cal_AS"));
        if (list.size() == 0) {
          System.out.println("continue fucking next month");
          next = driver.findElements(By.linkText("<Next>"));
          next.get(0).click();
        } else {
          System.out.println("go go go go");
        }
}
