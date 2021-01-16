# Weather-eco api
## root: https://meteo-lsn.herokuapp.com/

### Members management
<table>
	<thead>
		<tr>
			<th>Verb</th>
			<th>URL</th> 
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr style='color: orange'>
			<td>GET</td>
			<td>/api/members</td>
			<td>Admin</td>
			<td>list all members</td>
 		</tr>
		<tr style='color : orange'>
			<td>GET</td>
			<td>/api/members/{id}</td>
			<td>Admin - Owner</td>
			<td>search a member by his Id</td>
		</tr>
		<tr style='color : blue'>
			<td>GET</td>
			<td>/api/members/me</td>
			<td>Owner</td>
			<td>show member connected</td>
		</tr>
		<tr style='color : green'>
			<td>POST</td>
			<td>/api/members</td>
			<td>Public</td>
			<td>create new member</td>
		</tr>
		<tr style='color : orange'>
			<td>PUT</td>
			<td>/api/members/{id}</td>
			<td>Admin - Owner</td>
			<td> Update member</td>
		</tr>
		<tr style='color : orange'>
			<td>DELETE</td>
			<td>/api/members/{id}</td>
			<td>Admin - Owner</td>
			<td>delete member from his Id</td>
		</tr>
	</tbody>
</table>

#### Json template : 

<table>
  <thead>
    <tr>
      <th>label</th>
      <th>type</th>
      <th>required</th>
    </tr>
  </thead>
  <tbody>
    <tr style='color : blue'>
      <td>id</td>
      <td>number</td>
      <td>required for put</td>
    </tr>
    <tr style='color : green'>
      <td>dateAdd</td>
      <td>string with date format</td>
      <td>not required. default value : now</td>
    </tr>
    <tr style='color : blue'>
      <td>lastName</td>
      <td>string</td>
      <td>required</td>
    </tr>
    <tr style='color : blue'>
      <td>firstName</td>
      <td>string</td>
      <td>required</td>
    </tr>
    <tr style='color : blue'>
      <td>userName</td>
      <td>string</td>
      <td>required</td>
    </tr>
    <tr style='color : blue'>
      <td>email</td>
      <td>string</td>
      <td>required</td>
    </tr>
    <tr style='color : blue'>
      <td>roleId</td>
      <td>number</td>
      <td>required</td>
    </tr>
    <tr style='color : green'>
      <td>favoritesId</td>
      <td>number</td>
      <td>not required</td>
    </tr>
    <tr style='color : green'>
      <td>topicId</td>
      <td>number</td>
      <td>not required</td>
    </tr>
  </tbody>
</table>


### Favotite management

<table>
	<thead>
		<tr>
			<th>Verb</th>
			<th>URL</th> 
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr style='color : red'>
			<td>GET</td>
			<td>/api/favorite</td>
			<td>Nobody</td>
			<td>Prohibited</td>
 		</tr>
		<tr style='color : blue'>
			<td>GET</td>
			<td>/api/favorite/{id}</td>
			<td>Owner</td>
			<td>search a favorite from Id</td>
		</tr>
		<tr style='color : blue'>
			<td>POST</td>
			<td>/api/favorite</td>
			<td>Connected user</td>
			<td>create new favorite</td>
		</tr>
		<tr style='color : blue'>
			<td>PUT</td>
			<td>/api/favorite/{id}</td>
			<td>Owner</td>
			<td> Update favorite</td>
		</tr>
		<tr style='color : blue'>
			<td>DELETE</td>
			<td>/api/favorite/{id}</td>
			<td>Owner</td>
			<td>delete favorite from Id. <br>Automatic delete cascading by cities</td>
		</tr>
	</tbody>
</table>

#### Json template : 

<table>
  <thead>
    <tr>
      <th>label</th>
      <th>type</th>
      <th>required</th>
    </tr>
  </thead>
  <tbody>
    <tr style='color : blue'>
      <td>id</td>
      <td>number</td>
      <td>required for put</td>
    </tr>
    <tr style='color : green'>
      <td>dateAdd</td>
      <td>string with date format</td>
      <td>not required. default value : now</td>
    </tr>
    <tr style='color : green'>
      <td>showWeather</td>
      <td>boolean value [ 0|1, false|true ]</td>
      <td>not required</td>
    </tr>
    <tr style='color : green'>
      <td>showPolluants</td>
      <td>boolean value [ 0|1, false|true ]</td>
      <td>not required</td>
    </tr>
    <tr style='color : green'>
      <td>polluants</td>
      <td>array of Polluant Enummeration value</td>
      <td>not required</td>
    </tr>
    <tr style='color : green'>
      <td>infoWeather</td>
      <td>array of weather Enummeration value</td>
      <td>not required</td>
    </tr>
    <tr style='color : blue'>
      <td>cityId</td>
      <td>number</td>
      <td>required</td>
    </tr>
    <tr style='color : blue'>
      <td>memberId</td>
      <td>number</td>
      <td>required</td>
    </tr>
  </tbody>
</table>




### cities management

<table>
	<thead>
		<tr>
			<th>Verb</th>
			<th>URL</th> 
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr style='color : red'>
			<td>GET</td>
			<td>/api/cities</td>
			<td>Nobody</td>
			<td>Prohibited</td>
 		</tr>
		<tr style='color : red'>
			<td>GET</td>
			<td>/api/cities/{id}</td>
			<td>Nobody</td>
			<td>Prohibited</td>
		</tr>
		<tr style='color : orange'>
			<td>GET</td>
			<td>/api/cities/updatebdd</td>
			<td>Admin</td>
			<td>manually update bdd</td>
		</tr>
		<tr style='color : red'>
			<td>POST</td>
			<td>/api/cities</td>
			<td>Nobody</td>
			<td>Prohibited</td>
		</tr>
		<tr style='color : red'>
			<td>PUT</td>
			<td>/api/cities/{id}</td>
			<td>Nobody</td>
			<td>Prohibited</td>
		</tr>
		<tr style='color : orange'>
			<td>DELETE</td>
			<td>/api/cities/{id}</td>
			<td>Admin</td>
			<td>delete city from id</td>
		</tr>
	</tbody>
</table>

### topic management

<table>
	<thead>
		<tr>
			<th>Verb</th>
			<th>URL</th> 
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr style='color : green'>
			<td>GET</td>
			<td>/forum/topic</td>
			<td>Public</td>
			<td>list all topic</td>
 		</tr>
		<tr style='color : green'>
			<td>GET</td>
			<td>/topic/{id}</td>
			<td>Public</td>
			<td>search a topic from Id</td>
		</tr>
		<tr style='color : orange'>
			<td>POST</td>
			<td>/topic</td>
			<td>Admin</td>
			<td>create new topic</td>
		</tr>
		<tr style='color : orange'>
			<td>PUT</td>
			<td>/topic/{id}</td>
			<td>Admin</td>
			<td> Update a topic</td>
		</tr>
		<tr style='color : orange'>
			<td>DELETE</td>
			<td>/topic/{id}</td>
			<td>Admin</td>
			<td>delete topic from Id</td>
		</tr>
	</tbody>
</table>

#### Json template : 

<table>
  <thead>
    <tr>
      <th>label</th>
      <th>type</th>
      <th>required</th>
    </tr>
  </thead>
  <tbody>
    <tr style='color : blue'>
      <td>id</td>
      <td>number</td>
      <td>required for put</td>
    </tr>
    <tr style='color : green'>
      <td>dateAdd</td>
      <td>string with date format</td>
      <td>not required. default value : now</td>
    </tr>
    <tr style='color : blue'>
      <td>label</td>
      <td>string</td>
      <td>required</td>
    </tr>
    <tr style='color : green'>
      <td>subjectsId</td>
      <td>Array ok number</td>
      <td>not required</td>
    </tr>
    <tr style='color : blue'>
      <td>memberId</td>
      <td>number</td>
      <td>required</td>
    </tr>
  </tbody>
</table>




### subject management

<table>
	<thead>
		<tr>
			<th>Verb</th>
			<th>URL</th> 
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr style='color : green'>
			<td>GET</td>
			<td>/forum/subject</td>
			<td>Public</td>
			<td>list all subject</td>
 		</tr>
		<tr style='color : green'>
			<td>GET</td>
			<td>/subject/{id}</td>
			<td>Public</td>
			<td>search a subject from Id</td>
		</tr>
		<tr style='color : blue'>
			<td>POST</td>
			<td>/subject</td>
			<td>Connected user</td>
			<td>create new subject</td>
		</tr>
		<tr style='color : orange'>
			<td>PUT</td>
			<td>/subject/{id}</td>
			<td>Admin - Owner</td>
			<td> Update a subject</td>
		</tr>
		<tr style='color : orange'>
			<td>DELETE</td>
			<td>/subject/{id}</td>
			<td>Admin - Owner</td>
			<td>delete subject from Id</td>
		</tr>
	</tbody>
</table>

#### Json template : 

<table>
  <thead>
    <tr>
      <th>label</th>
      <th>type</th>
      <th>required</th>
    </tr>
  </thead>
  <tbody>
    <tr style='color : blue'>
      <td>id</td>
      <td>number</td>
      <td>required for put</td>
    </tr>
    <tr style='color : green'>
      <td>dateAdd</td>
      <td>string with date format</td>
      <td>not required. default value : now</td>
    </tr>
    <tr style='color : blue'>
      <td>label</td>
      <td>string</td>
      <td>required</td>
    </tr>
    <tr style='color : green'>
      <td>answersId</td>
      <td>Array ok number</td>
      <td>not required</td>
    </tr>
    <tr style='color : blue'>
      <td>topicId</td>
      <td>number</td>
      <td>required</td>
    </tr>
     <tr style='color : blue'>
      <td>memberId</td>
      <td>number</td>
      <td>required</td>
    </tr>
  </tbody>
</table>

### answer management

<table>
	<thead>
		<tr>
			<th>Verb</th>
			<th>URL</th> 
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr style='color : green'>
			<td>GET</td>
			<td>/forum/answer</td>
			<td>Public</td>
			<td>list all answers</td>
 		</tr>
		<tr style='color : green'>
			<td>GET</td>
			<td>/answer/{id}</td>
			<td>Public</td>
			<td>search an answer from Id</td>
		</tr>
		<tr style='color :blue'>
			<td>POST</td>
			<td>/answer</td>
			<td>Connected user</td>
			<td>create new answer</td>
		</tr>
		<tr style='color : orange'>
			<td>PUT</td>
			<td>/answer/{id}</td>
			<td>Admin - Owner</td>
			<td> Update a answer</td>
		</tr>
		<tr style='color : orange'>
			<td>DELETE</td>
			<td>/answer/{id}</td>
			<td>Admin - Owner</td>
			<td>delete answer from Id</td>
		</tr>
	</tbody>
</table>

#### Json template : 

<table>
  <thead>
    <tr>
      <th>label</th>
      <th>type</th>
      <th>required</th>
    </tr>
  </thead>
  <tbody>
    <tr style='color : blue'>
      <td>id</td>
      <td>number</td>
      <td>required for put</td>
    </tr>
    <tr style='color : green'>
      <td>dateAdd</td>
      <td>string with date format</td>
      <td>not required. default value : now</td>
    </tr>
    <tr style='color : blue'>
      <td>contain</td>
      <td>string</td>
      <td>required</td>
    </tr>
     <tr style='color : green'>
      <td>like</td>
      <td>number</td>
      <td>not required. default value 0</td>
    </tr>
    <tr style='color : green'>
      <td>commentsId</td>
      <td>Array ok number</td>
      <td>not required</td>
    </tr>
    <tr style='color : blue'>
      <td>subjectId</td>
      <td>number</td>
      <td>required</td>
    </tr>
     <tr style='color : blue'>
      <td>memberId</td>
      <td>number</td>
      <td>required</td>
    </tr>
  </tbody>
</table>

### comment management

<table>
	<thead>
		<tr>
			<th>Verb</th>
			<th>URL</th> 
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr style='color : green'>
			<td>GET</td>
			<td>/forum/comment</td>
			<td>Public</td>
			<td>list all comment</td>
 		</tr>
		<tr style='color : green'>
			<td>GET</td>
			<td>/comment/{id}</td>
			<td>Public</td>
			<td>search a comment from Id</td>
		</tr>
		<tr style='color : blue'>
			<td>POST</td>
			<td>/comment</td>
			<td>Connected user</td>
			<td>create new comment</td>
		</tr>
		<tr style='color : orange'>
			<td>PUT</td>
			<td>/comment/{id}</td>
			<td>Admin - Owner</td>
			<td> Update a comment</td>
		</tr>
		<tr style='color : orange'>
			<td>DELETE</td>
			<td>/comment/{id}</td>
			<td>Admin - Owner</td>
			<td>delete comment from Id</td>
		</tr>
	</tbody>
</table>

#### Json template : 

<table>
  <thead>
    <tr>
      <th>label</th>
      <th>type</th>
      <th>required</th>
    </tr>
  </thead>
  <tbody>
    <tr style='color : blue'>
      <td>id</td>
      <td>number</td>
      <td>required for put</td>
    </tr>
    <tr style='color : green'>
      <td>dateAdd</td>
      <td>string with date format</td>
      <td>not required. default value : now</td>
    </tr>
    <tr style='color : blue'>
      <td>contain</td>
      <td>string</td>
      <td>required</td>
    </tr>
     <tr style='color : green'>
      <td>like</td>
      <td>number</td>
      <td>not required. default value 0</td>
    </tr>
    <tr style='color : green'>
      <td>commentsId</td>
      <td>Array ok number</td>
      <td>not required</td>
    </tr>
    <tr style='color : blue'>
      <td>originId</td>
      <td>number</td>
      <td>required</td>
    </tr>
     <tr style='color : blue'>
      <td>memberId</td>
      <td>number</td>
      <td>required</td>
    </tr>
  </tbody>
</table>
