<template>
    <div class="container mt-3">
       <h1 class="display-1 text-center">영화 목록</h1>
       <table class="table table-hover mt-3">
           <thead class="table-dark">
               <tr>
                   <th>번호</th>
                   <th>장르</th>
                   <th>제목</th>
                   <th>감독</th>
                   <th>배급사</th>
                   <th>개봉일</th>
                   <th>상영시간</th>
                   <th>줄거리</th>
                   <th>bcode</th>
               </tr>
           </thead>
           <tbody>
               <tr class="cursor-pointer" v-for="row in result" :key="row.movie_num">
                   <td>{{ row.movie_num }}</td>
                   <td>{{ row.genre }}</td>
                   <td style="color: blueviolet;">{{ row.title }}★{{ row.title.length }}★</td>
                   <td>{{ row.directore }}</td>
                   <td>{{ row.producer }}</td>
                   <td>{{ row.release_date }}</td>
                   <td>{{ row.runtime }}</td>
                   <td>{{row.description}}</td>
                   <td>{{ row.bcode }}</td>
               </tr>
           </tbody>
       </table>
   </div>

  
</template>

<script>
import axios from 'axios';
import store from '@/store';
export default {
   name: 'MovieList',
   data() {
       return {
           result: []
       }
   },
   created() {
       this.getDB()
       console.log(store)
   },
   methods: {
       getDB() {
           axios
               .post('http://localhost:8080/movieList')
               .then((response) => {
                   console.log(response)
                   this.result = response.data.result
               })
               .catch((error) => {
                   console.log(error)
               })
       }
   },
}
</script>

<style>

</style>