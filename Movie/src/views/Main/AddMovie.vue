<template>
  <div>
    <h1 class="title">영화 생성</h1>
    <form @submit.prevent="AddMovie">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" id="title" v-model="movie.title" required />
      </div>
      <div class="form-group">
        <label for="genre">장르</label>
        <input type="text" id="genre" v-model="movie.genre" required />
      </div>
      <div class="form-group">
        <label for="directore">감독</label>
        <input type="text" id="directore" v-model="movie.directore" required />
      </div>
      <div class="form-group">
        <label for="producer">배급사</label>
        <input type="text" id="producer" v-model="movie.producer" />
      </div>
      <div class="form-group">
        <label for="release_date">개봉일</label>
        <input type="date" id="release_date" v-model="movie.release_date" />
      </div>
      <div class="form-group">
        <label for="runtime">상영시간</label>
        <input type="number" id="runtime" v-model="movie.runtime" />
      </div>
      <div class="form-group">
        <label for="description">줄거리</label>
        <textarea id="description" v-model="movie.description"></textarea>
      </div>
      <div class="form-group">
        <label for="bcode">bcode</label>
        <input type="text" id="bcode" v-model="movie.bcode" />
      </div>
      <button type="submit" class="btn btn-primary">영화 생성</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'AddMovie',
  data() {
    return {
      movie: {
        title: '',
        genre: '',
        directore: '',
        producer: '',
        release_date: '',
        runtime: '',
        description: '',
        bcode: '',
      },
    };
  },
  methods: {
    async AddMovie() { // async 와 await : 비동기 작업을 더 간편하게 처리하기 위해 사용하는 키워드, 항상 promise를 반환함.
      try {
        const response = await axios.post('http://localhost:8080/AddMovie', this.movie);
        alert('영화 생성 성공!');
        this.$router.push('/movieList'); // 생성 후 영화 목록 페이지로 이동
      } catch (error) {
        console.error('영화 생성 실패:', error);
        alert('영화 생성에 실패했습니다.');
      }
    },
  },
};
</script>

<style>
/* 스타일은 필요에 따라 추가하세요 */
</style>