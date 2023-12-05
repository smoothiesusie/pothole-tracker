<!-- <template>
    <div id="map" style="height: 400px; width: 100%;"></div>
</template>

  <script>
  
  
  export default {
    name: 'Maps',
    mounted() {
      this.initMap();
    },


    methods: {
      async initMap() {
        const loader = new Loader({
          apiKey: "YOUR_API_KEY", 
          version: "weekly",
         
        });
  
        try {
          await loader.load();
          this.map = new google.maps.Map(document.getElementById("map"), {
            center: { lat: -34.397, lng: 150.644 },
            zoom: 8,
          });
        } catch (error) {
          console.error("Error loading Google Maps:", error);
        }
      }
    }
  };
  </script>
  
  <style>
  #map {
    height: 100%;
  }
  html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }
  </style> -->
 
 
 
 <template>

<!-- <GmapMap 
   :center="{lat:10, lng:10}"
   :zoom="7"
   style="width:640px; height360px;"
   ></GmapMap> -->
  </template>


<script>
export default {


}
</script>

<style>


</style>