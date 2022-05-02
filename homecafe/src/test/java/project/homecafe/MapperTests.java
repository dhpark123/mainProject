package project.homecafe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import project.homecafe.domain.MemberDTO;
import project.homecafe.mapper.MemberMapper;

@SpringBootTest
public class MapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testOfInsert() {
        MemberDTO params = new MemberDTO();
        params.setName("박대한");
        params.setArea("화성");
        params.setPhoneNumber("010-7794-0306");
    }

}
