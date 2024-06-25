RebaseBranchFirstTest.class (RebaseBranch1)

RebaseBranchSecondTest.class (RebaseBranch2)

RebaseBranchThirdTest.class (RebaseBranch3)

---
AS-IS

- main
    - <- RebaseBranch1: RebaseBranchFirstTest.class 생성
        - <- RebaseBranch2: RebaseBranchSecondTest.class 생성
            - <- RebaseBranch3: RebaseBranchThirdTest.class 생성
                - <- RebaseBranch4: RebaseBranchFourthTest.class 생성
    - <- RebaseBranch5: RebaseBranchFifthTest.class 생성
    - <- RebaseBranch6: RebaseBranchSixthTest.class 생성

---
TO-BE
(Rebase Branch 5가 4위로 올라가도록 변경)

- main
    - <- RebaseBranch1: RebaseBranchFirstTest.class 생성
        - <- RebaseBranch2: RebaseBranchSecondTest.class 생성
            - <- RebaseBranch3: RebaseBranchThirdTest.class 생성
                - <- RebaseBranch4: RebaseBranchFourthTest.class 생성
                    - <- RebaseBranch5: RebaseBranchFifthTest.class 생성
                        - <- RebaseBranch6: RebaseBranchSixthTest.class 생성

---
TO-BE #1 (handmade with merge)
- 5번 checkout
- 4번 rebase
- 6번 checkout
- 5번 rebase

TO-BE #2 (with my ref)
- let's get it