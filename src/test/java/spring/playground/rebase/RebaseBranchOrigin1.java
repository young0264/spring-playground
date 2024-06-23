package spring.playground.rebase;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class RebaseBranchOrigin1 {

    @Test
    void originBranch1() {
        log.info("Changes in origin branch1");
    }

    @Test
    void branch2_2FromOriginBranch1() {
        log.info("Changes in origin branch2-2");
    }

}
