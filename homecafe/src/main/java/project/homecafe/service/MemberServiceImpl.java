package project.homecafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.homecafe.domain.MemberDTO;
import project.homecafe.mapper.MemberMapper;

import java.util.Collections;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public boolean registerMember(MemberDTO params) {
        int queryResult = 0;

        if (params.getIdx() == null) {
            queryResult = memberMapper.insertMember(params);
        } else {
            queryResult = memberMapper.updateMember(params);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public MemberDTO getMemberDetail(Long idx) {
        return memberMapper.selectMemberDetail(idx);
    }

    @Override
    public boolean deleteMember(Long idx) {
        int queryResult = 0;

        MemberDTO member = memberMapper.selectMemberDetail(idx);

        if (member != null && "N".equals(member.getDeleteYn())) {
            queryResult = memberMapper.deleteMember(idx);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<MemberDTO> getMemberList() {
        List<MemberDTO> memberList = Collections.emptyList();

        int memberTotalCount = memberMapper.selectMemberTotalCount();

        if (memberTotalCount > 0) {
            memberList = memberMapper.selectMemberList();
        }
        return memberList;
    }
}
