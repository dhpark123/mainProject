package project.homecafe.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDTO {
    private Long idx;
    private String name;
    private String area;
    private String phoneNumber;
    private String mangerYn;
    private LocalDateTime insertMember;
    private LocalDateTime deleteMember;
    private String deleteYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private Long visitCnt;
}
