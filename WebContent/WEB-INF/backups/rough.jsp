<div class="">
				<div class="rowmy">
					<form action="${pageContext.request.contextPath}/findMatchByLocation">
						
						<div class="column-big">
    						<div><input class="form-control" name="country" type="text" placeholder="Search" aria-label="Search"></div>
						</div>
						<div class="column-small">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</div>
						
					</form>
				</div>
				
				<form action="${pageContext.request.contextPath}/search">
					<div class="rowmy">
						<div class="column">
							<div><label for="profiletextarea">About Me</label></div>
						</div>
						
						<div class="column">
							<div><textarea class="proftextarea" name="profile" id="profiletextarea" rows="20" cols="100"></textarea></div>
						</div>
					</div>
					<br>
					<div class="rowmy">
						<div class="column">
							<div><label for="lookingFor">Looking For</label></div>
						</div>
			
						<div class="column">
							<div><textarea class="proftextarea" name="lookingFor" id="lookingFor" rows="20" cols="100"></textarea></div>
						</div>
					</div>
		
					<div class="rowmy">
						<div class="form-group col-md-2">
							<div><input type="submit" name="login"></div>
						</div>
					</div>
				</form>
			</div>
			
			
			
			
			
			<!-- Exactly copy of Pure Matrimony how I look -->
			<!-- needs biodiv.css -->
			<div id="dashboard" class="maindata">
		    		<div id="user-block">
		    			<div class="profile-image">
		    				<p>
		    					<a id="mainfullimage" href="http://placehold.it/400/00F/FFF"><img src="http://placehold.it/119/00F/FFF" alt="click to see larger photo" title="click to see larger photo"></a>
		    				</p>
		    				<p><button><a href="#createphotoprofilepage" class="button-small">Change Photo</a></button></p>
		    			</div>
		    			
	    				<ul class="summary">
		    				<li><label>Username:</label></li>
		    				<li><label>Last Login:</label></li>
		    				<li id="hp_ptestlink"><a href="#someLink">_</a></li>
		    			</ul>
		    			
		    			<ul class="primary">
		    				<li id="updateli"><a href="#prfprofile.php">Edit my profile</a></li>
		    				<li id="findexactli"><a href="#purematches.php">Find my exact </a></li>
		    				<li id="findli"><a href="#bestmatch.php">Members I am looking for</a></li>
		    				<li id="lookformeli"><a href="#lookingforme.php">Members looking for me</a></li>
		    				<li id="myfavli"><a href="#favourites.php">My Favourites</a></li>
		    				<li id="youtubeli"><a href="" target="_blank">Watch our Quick Start video</a></li>
		    			</ul>
		    		</div><!-- user-block -->    	
		    		<div class="myIdeal">
		    			<div class="block">
		    				<h3>My Ideal Matches..</h3>
		    				<ul class="photo-access">
		    					<li class="biodatacontainer">
		    						<div id="midealm${useridnumber}" onmouseover="">
		    							<a href="#linktoseethatprofile">
		    								<!-- <div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=142655&amp;size=small') no-repeat top center;"><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div> -->
		    								<div class="smallimage" style="width: 90px; height: 90px; background:url('Mywebsite/viewphoto.php?userid=142655&amp;size=small') no-repeat top center;"><img width="90px" height="90px" src="http://placehold.it/90/00F/FFF" alt="" border="0"></div>
		    								<br>
		    								<div id="midealm${useridnumber}hook">The name of this match</div>
		    							</a>
		    						</div><!-- the div of this match -->
		    						<div class="matchBioDiv" id="midealm${userid}_member_popup">
		    							<div class="bioginner">
		    								<div class="biogactioncontainer">
		    									<div class="bioact">&nbsp;<img class="bioideal" src="http://placehold.it/90/00F/FF0"></div><!-- I should have my logo -->
		    								</div>
		    								<p><a href="#view.php?candid=userid">candid years old & marriage status</a></p>
		    								<p><a href="#view.php?candid=142655">Asian - Indian</a></p>
		    								<p><a href="#view.php?candid=142655">India, Karnataka</a></p>
		    								<p><a href="#view.php?candid=142655">Citizen</a></p>
		    								<p><span class="loggedin">logged in 20 hours ago</span></p>
		    								<div class="biogfooter"><a href="messageto.php?candid=142655">Send message</a></div>
		    							</div>
		    							<div class="biogfooter"><a href="messageto.php?candid=142655">Send message</a></div>
		    						</div>
		    					</li>
		    				</ul>
		    				<br class="clear">
		    			</div>
		    			&nbsp;
		    		</div>
		    		<div id="lastViewers">
		    			<div id="block">
		    				<h3 class="">Members who've recently viewed me ...</h3>
		    				<ul class="photo-access">																	<!-- this is  a short for member viewed me -->
		    					<li class="biodatacontainer">
		    						<div class="biodatacontainer" onmouseover="FocusOnMemberBiog('mrvm148206', 148206, 0, 0, 'recentview', '6 Jul 2018');" id="mrvm${userid}hook">
			    						<a href="#view.php?candid=148206">
			    							<div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=148206&amp;size=small') no-repeat top center; margin:auto;">
			    								<img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0">
			    							</div><br>Amatullah177</a><br>6 Jul 2018</div>
    							</li>
		    					<li class="biodatacontainer"><div class="biodatacontainer" onmouseover="FocusOnMemberBiog('mrvm148783', 148783, 0, 0, 'recentview', 'Sunday');" id="mrvm148783hook"><a href="/view.php?candid=148783"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=148783&amp;size=small') no-repeat top center; margin:auto;"><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><br>H00riya</a><br>Sunday</div></li>
		    					<li class="biodatacontainer"><div class="biodatacontainer" onmouseover="FocusOnMemberBiog('mrvm139496', 139496, 0, 0, 'recentview', '4 Jul 2018');" id="mrvm139496hook"><a href="/view.php?candid=139496"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=139496&amp;size=small') no-repeat top center; margin:auto;"><span class="hasViewedBand" href="/view.php?candid=139496">Viewed</span><img width="90px" height="90px" src="${pageContext.request.contextPath }/img/template/blank.gif" alt="" border="0"></div><br>Sulthanashaik999</a><br>4 Jul 2018</div></li>
		    					<li class="biodatacontainer"><div class="biodatacontainer" onmouseover="FocusOnMemberBiog('mrvm48143', 48143, 0, 0, 'recentview', '3 Jul 2018');" id="mrvm48143hook"><a href="#view.php?candid=48143"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=48143&amp;size=small') no-repeat top center; margin:auto;"><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><br>UmmMus3ab</a><br>3 Jul 2018</div></li>
		    					<li class="biodatacontainer"><div class="biodatacontainer" onmouseover="FocusOnMemberBiog('mrvm137845', 137845, 0, 0, 'recentview', '2 Jul 2018');" id="mrvm137845hook"><a href="/view.php?candid=137845"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=137845&amp;size=small') no-repeat top center; margin:auto;"><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><br>AFShurairah</a><br>2 Jul 2018</div></li>
		    				</ul>
		    				<br class="clear">
		    				<p class="right"><a href="#viewedme.php">View all (93)</a></p>
		    				<br class="clear">
		    			</div>
		    		</div>
		    		<div id="newMembers">
		    			<div class="block">
		    				<h3>New members of Pure Matrimony ...</h3>
		    				<ul class="photo-access">
		    					<li class="biodatacontainer"><div id="lmnew147567" onmouseover="FocusOnMemberBiog('lmnew147567', 147567, 0, 0, 'newmember');"><a href="/view.php?candid=147567"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=147567&amp;size=small') no-repeat top center;"><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><br><div id="lmnew147567hook">samadmaliha</div></a>6 Jun 2018</div><div class="memberBiogDiv" id="lmnew147567_member_popup"></div></li>
		    					<li class="biodatacontainer"><div id="lmnew142463" onmouseover="FocusOnMemberBiog('lmnew142463', 142463, 0, 0, 'newmember');"><a href="/view.php?candid=142463"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=142463&amp;size=small') no-repeat top center;"><span class="hasViewedBand">Viewed</span><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><br><div id="lmnew142463hook">sabiha1</div></a>26 Jan 2018</div><div class="memberBiogDiv" id="lmnew142463_member_popup"></div></li>
		    				</ul>
		    				<p class="right"><a href="newmembers.php">see more</a></p>
		    				
		    				<br class="clear">
		    			</div>
		    		</div>
		    		<div id="view-profile">
		    			<div id="photoViewers">
		    				<div class="summaryList" id="seeMyPhoto">
		    					<h3><a onclick="ShowHideQuestions('PView');">Manage which members can see my photos<img id="questionsimgPView" src="${pageContext.request.contextPath}/img/template/arrow-closex.png"><span id="questionsspanPView">close</span></a>
		    					</h3>
		    					<div id="questionDivView">
		    						<ul class="photo-access"><li class="pending biogcontainer"><div><a class="paImageLink" id="hook" href="/view.php?candid=139496"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=139496&amp;size=small') no-repeat top center; margin: auto;"><span class="hasViewedBand">Viewed</span><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><div>Sulthanashaik999</div></a><a href="index.php?candid=139496&amp;photogive=1&amp;prid=691872">Accept</a> | <a href="index.php?candid=139496&amp;photoremove=1&amp;prid=691872">Reject</a></div></li><li class="pending biogcontainer"><div><a class="paImageLink" id="hook" href="/view.php?candid=145915"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=145915&amp;size=small') no-repeat top center; margin: auto;"><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><div>Kashaf02</div></a><a href="index.php?candid=145915&amp;photogive=1&amp;prid=690897">Accept</a> | <a href="index.php?candid=145915&amp;photoremove=1&amp;prid=690897">Reject</a></div></li><li class="pending biogcontainer"><div><a class="paImageLink" id="hook" href="/view.php?candid=148783"><div class="smallimage" style="width: 90px; height: 90px; background:url('https://purematrimony.com/viewphoto.php?userid=148783&amp;size=small') no-repeat top center; margin: auto;"><img width="90px" height="90px" src="${pageContext.request.contextPath}/img/template/blank.gif" alt="" border="0"></div><div>H00riya</div></a><a href="index.php?candid=148783&amp;photogive=1&amp;prid=695616">Accept</a> | <a href="index.php?candid=148783&amp;photoremove=1&amp;prid=695616">Reject</a></div></li></ul>
		    						<div class="clear"></div>
		    					</div>
		    				</div>
		    			</div>
		    			<div id="hpHowImpAnswers"></div>
		    			<div id="hpSetQAnswers">
		    				<div id="MySetQAnswers" class="summary">
		    					<h3>
		    						<a onclick="ShowHideQuestions('setQ');">My answers to set questions<img id="questionsimgSetQ" src="${pageContext.request.contextPath}/img/template/arrow-openx.png">
		    							<span id="questionsspanSetQ">view</span>
		    						</a>
		    					</h3>
		    				</div>
		    				<div id="QuestionsdivSetQ">
		    					
		    				</div>
		    			</div>
		    		</div>
		    	</div><!-- dashboard -->
		    	
		    	
		    	
		    	
		    	
		    	
		    