<template>
    <div>
        <div><router-link to="/Sub">1.Sub 리스트</router-link></div>
        <div><router-link to="/user">2.사용자 명단</router-link></div>
    <!-- Features Section -->
    <section id="features">
      <div class="container">
        <header>
          <h2>오늘의 추천 영화! <strong>Best 3</strong>!</h2>
        </header>
        <div class="row aln-center">
          <div class="col-4 col-6-medium col-12-small">
            <section>
              <a href="#" class="image featured">
                <img src="#" width="300px" alt="영화 이미지" />
              </a>
              <header>
                <h4>
                  실시간 평점&nbsp; ★
                  <span class="cm_icon_star"></span>
                </h4>
                <h3>영화 제목</h3>
              </header>
              <p>영화 설명 텍스트...</p>
            </section>
          </div>
          <div class="col-4 col-6-medium col-12-small">
            <section>
              <a href="#" class="image featured">
                <img src="#" width="300px" alt="영화 이미지" />
              </a>
              <header>
                <h4>
                  실시간 평점&nbsp; ★
                  <span class="cm_icon_star"></span>
                </h4>
                <h3>영화 제목</h3>
              </header>
              <p>영화 설명 텍스트...</p>
            </section>
          </div>
          <div class="col-4 col-6-medium col-12-small">
            <section>
              <a href="#" class="image featured">
                <img src="#" width="300px" alt="영화 이미지" />
              </a>
              <header>
                <h4>
                  실시간 평점&nbsp; ★
                  <span class="cm_icon_star"></span>
                </h4>
                <h3>영화 제목</h3>
              </header>
              <p>영화 설명 텍스트...</p>
            </section>
          </div>
        </div>
        <div class="col-12">
          <ul class="actions">
            <li><router-link to="/movieList">영화 대여하러가기</router-link></li>
          </ul>
        </div>
      </div>
    </section>

    <!-- Banner Section -->
    <section id="banner">
      <div class="container">
        <h1 style="color: black;">이달의 신작을 만나보세요!</h1><br /><br /><br />
        <div class="banner-images">
          <div class="banner-item">
            <strong>이달의 신작!</strong><br /><br />
            <a href="#">
              <img src="#" width="300px" alt="신작 이미지" />
            </a>
          </div>
          <div class="banner-item">
            <strong>이달의 신작!</strong><br /><br />
            <a href="#">
              <img src="#" width="300px" alt="신작 이미지" />
            </a>
          </div>
          <div class="banner-item">
            <strong>이달의 신작!</strong><br /><br />
            <a href="#">
              <img src="#" width="300px" alt="신작 이미지" />
            </a>
          </div>
        </div>
      </div>
      <br /><br /><br />
      <h1 style="color: black;">시사회 일정</h1>
      <div class="container">
        <div class="banner-images">
          <div class="banner-item">
            <br /> 24.07.24<br />
            <img src="#" width="450px" alt="시사회 이미지" />
          </div>
          <div class="banner-item">
            <br /> 20.04.22<br />
            <img src="#" width="450px" alt="시사회 이미지" />
          </div>
        </div>
      </div>
      <br /><br /><br />
      <div style="color: red;">
        ※ 현재 영화반납 기한이 지났음에도 불구하고 영화를 반납하지 않는 회원님들이 있습니다.
      </div>
      <div style="color: red;">
        자세한 사항은 <a href="#">영화대여규칙</a>을 참고해 주시길 바랍니다.
      </div>
    </section>
    </div>
</template>

<script>
export default {
    name: 'MainPage'
}
</script>

<style>
 @import '@/assets/MainPage.css';
</style>