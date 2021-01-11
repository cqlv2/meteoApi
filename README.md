


#Weather-eco api
## root: http://localhost:8080/api


#### /members 

<table>
	<thead>
		<tr> <th> Verb </th> <th> url </th> <th> action </th> </tr>
	</thead>
	<tbody>
		<tr> <td>GET</td> 		<td>"/members"</td> 		<td> list all members </td> </tr>
		<tr> <td>GET</td> 		<td>"/members/{id}"</td> 	<td> show one member </td> </tr>
		<tr> <td>POST</td> 		<td>"/members"</td> 		<td> create new member(require json file in requestbody) </td> </tr>
		<tr> <td>PUT</td> 		<td>"/members"</td> 		<td> Update member(require json file in requestbody) </td> </tr>
		<tr> <td>DELETE</td> 	<td>"/members/{id}"</td> 	<td> delete member from his Id </td> </tr>
	</tbody>
</table>




#### /favorite
#### /city
#### /weather
#### /poluant
#### /encode

#Weather-eco forum api
## root: http://localhost:8080/forum


#### /topic
#### /subject
#### /answer
#### /comment
