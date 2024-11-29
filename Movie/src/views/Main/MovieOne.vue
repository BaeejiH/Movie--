<template>
    <div class="movie-detail">
        <h1 class="title">영화 상세보기</h1>
        <form @submit.prevent="updateMovie">
            <table class="movie-table">
                <tr>
                    <th class="movie-label">번호</th>
                    <td><input type="number" v-model="movie.movie_num"></td>
                </tr>
                <tr>
                    <th class="movie-label">장르</th>
                    <td><input type="text" v-model="movie.genre"></td>
                </tr>
                <tr>
                    <th class="movie-label">제목</th>
                    <td><input type="text" v-model="movie.title"></td>
                </tr>
                <tr>
                    <th class="movie-label">감독</th>
                    <td><input type="text" v-model="movie.directore"></td>
                </tr>
                <tr>
                    <th class="movie-label">배급사</th>
                    <td><input type="text" v-model="movie.producer"></td>
                </tr>
                <tr>
                    <th class="movie-label">개봉일</th>
                    <td><input type="datetime" v-model="movie.release_date"></td>
                </tr>
                <tr>
                    <th class="movie-label">상영시간</th>
                    <td><input type="number" v-model="movie.runtime"></td>
                </tr>
                <tr>
                    <th class="movie-label">줄거리</th>
                    <td><textarea type="text" v-model="movie.description"></textarea></td>
                </tr>
                <tr>
                    <th class="movie-label">bcode</th>
                    <td><input type="number" v-model="movie.bcode"></td>
                </tr>

                <button @click="deleteMovie(movie.movie_num)" class="btn btn-danger">영화 삭제</button>
                <button @click="updateMovie(movie.movie_num)" class="btn btn-danger">수정</button>
            </table>
        </form>
    </div>
</template>

<script>
import store from '@/store';
import axios from 'axios';
export default {
    name: 'MovieOne',
    computed: {
        movie() {
            return this.$store.state.selectMovie;
        }
    },
    methods: {
        deleteMovie(movie_num) {
            if (confirm("정말로 삭제하시겠습니까?")) {
                axios.delete(`http://localhost:8080/movieList/${movie_num}`)// axios.delete ->서버에서 리소스를 삭제할때 사용, RestfulApi에서 delete 요청을 보낼때
                    .then(response => {
                        alert("영화가 삭제되었습니다.");
                        this.$router.push('/movieList');
                    })
                    .catch(error => {
                        alert("영화가 삭제되지 않았습니다.");
                        console.error("Error deleting movie:", error);
                    });
            }
        },
        updateMovie() {
            axios.put(`http://localhost:8080/movieList/${this.movie.movie_num}`, this.movie)
                .then(response => {
                    alert("영화 정보가 수정되었습니다.");
                    this.$store.commit('UPDATE_MOVIE', this.movie); // Vuex 상태 업데이트
                    this.$router.push('/movieList'); // 목록 페이지로 이동
                })
                .catch(error => {
                    alert("영화 정보를 수정하는 데 실패했습니다.");
                    console.error("Error updating movie:", error);
                });
        }
    },

}
</script>

<style>
.movie-detail {
    font-family: Arial, sans-serif;
    padding: 20px;
    background-color: #f8f8f8;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 900px;
    margin: 0 auto;
}

.title {
    font-size: 2em;
    font-weight: bold;
    color: #333;
    text-align: center;
    margin-bottom: 20px;
}

.movie-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.movie-table th,
.movie-table td {
    padding: 12px 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

.movie-table th {
    width: 120px;
    background-color: #f1f1f1;
    font-weight: 600;
    color: #555;
}

.movie-table td {
    font-size: 1.1em;
    color: #333;
}

.movie-label {
    font-weight: 600;
    color: #555;
}

.movie-table tr:hover {
    background-color: #f9f9f9;
}
</style>