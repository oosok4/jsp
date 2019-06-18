# jsp
localhost/jsp/login2 - 으로 접속시 login페이지가 나타납니다.
로그인 페이지에서는 기존의 가입되어진 회원이 아니면 로그인이 되어지지 않습니다.
회원가입되어진 아이디와 비밀빈호는 해당브라우저의 쿠키로 남아 위에입력한 도메인으로 재접속시에 
기록이 남아 sign in 버튼을 클릭시 로그인할 수 있습니다.
로그인을 하게되면 header.jsp에 로그인한 회원의 user_name이 나타나며 로그인을 거치지 않고 localhost/jsp/main으로 접속시
세션에 회원VO가 담겨 지지 않으므로 [접속 전 입니다.]라는 메세지가 나타납니다.
header의 오른쪽에는 현재 세션의 담겨진 VO를 null로 만들어주며 현재페이지를 localhost/jsp/login페이지로 이동시킵니다.

다시 로그인으로 돌아와서 브라우저의 좌측에는 left.jsp가 있습니다. 여기서 create_Board를 클릭하면 '게시판'목록을 생성시키거나 삭제 할 수 
있습니다. 게시판이름에 해당하는 TEXTAREA에 게시판 이름을 입력하고 공개페이지,비공개 페이지로 할지 선택한후 생성을 누르면 해당 게시판이 
생성됩니다.

페이지를 생성할때 임의적으로 시퀀스를 이용해서 게시판 아이디가 부여되기 때문에 버튼 클릭시 회원 아이디가 null이면 생성 !null이면 수정하는 메서
드를 사용합니다

만들어진 게시판 각각에도 아이디가 부여되며 각 게시판에서도 게시물을 작성 할 수 있습니다. 게시물등록을 통해 게시글 제목 게시물 내용 : (네이버 스마트 에디터 사용) 글씨 변경 가능 , 드래그를 이용한 사진 업로드를 할수 있고 첨부파일(5개 까지 가능)을 넣어서 게시물을 만들 수 있습니다.
만들어진 게시물은 한 페이지에 10게시물이 나타나며 페이지 네이션을 통해 10개 이후의 게시물을 확인 할 수 있습니다.

또 각 게시물에 답글 , 댓글을 써넣을 수 있으며 게시물 본인, 답글 본인, 댓글 작성자만이 자신이 쓴 게시물을 삭제할 권리를 갖습니다.