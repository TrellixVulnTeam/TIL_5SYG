//-----------------------------------------------
		// $(document).ready( function(){자스코딩} );
		//-----------------------------------------------
			// body 태그 안의 요소들을 읽어들인 후 익명함수 내부의 자스코딩을 실행
            $(document).ready( function(){
                // id=movieList 를 가진 태그를 관리하는 JQuery 객체의 메위주를 변수 tableObj 에 저장
                var tableObj = $("#movieList");
                // id=movieList 를 가진 태그 내부에 모든 tr을 관리 JQuery 객체 메위주를 변수 trObj에 저장
                var trObj = tableObj.find("tr");
                //var trObj = $("#movieList tr");
                // 홀수 tr을 관리 JQuery 객체 메위주를 변수 trOddObj에 저장
                var trOddObj = trObj.filter(":even");
                // 짝수 tr을 관리 JQuery 객체 메위주를 변수 trEvenObj에 저장
                var trEvenObj = trObj.filter(":odd");
                //--------------------------------------
                // 짝수번째 tr 감추기
                //--------------------------------------
                trEvenObj.hide();
                //홀수 tr태그에 마우스 대면 손모양으로 보이기
                trOddObj.css("cursor", "pointer");
                trOddObj.hover( 
                    function( ){
                        //짝수 tr 감추기
                        trEvenObj.hide();
                        // 마우스를 댄 홀수tr태그의 다음 짝수tr 보이기
                        $(this).next().show();
                    },
                    function( ){
                        //trEvenObj.hide();
                    }
                );
                // table 영역에서 마우스 빼면 짝수 tr 안보이기
                tableObj.hover(
                    function( ){
                    },
                    function( ){
                        trEvenObj.hide();
                    }
                );
    
             });