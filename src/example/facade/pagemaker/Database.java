package example.facade.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

// Facade 패턴에서 Facade의 제어를 받는 클래스에 해당
// Facade를 통해서만 접근 가능하도록 클래스, 생성자에 public 미사용
class Database {

    private static final String DIRECTORY_PATH = "src/example/facade/pagemaker/";

    // Facade를 통해서만 이 클래스를 이용 가능하도록 외부 클래스로부터 이 생성자를 은닉
    private Database() {
    }

    // 생성자를 노출시키지 않으면서 이 클래스에 정의된 작업을 수행하기 위해 static 메서드 사용
    // 지정한 데이터 파일에 관한 Properties의 인스턴스 생성 메서드
    public static Properties getProperties(String dbName) throws IOException {
        String filename = dbName + ".txt";
        Properties prop = new Properties();
        prop.load(new FileReader(DIRECTORY_PATH + filename));
        return prop;
    }
}
