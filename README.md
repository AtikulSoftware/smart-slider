<br/>
<p align="center">
  <a href="https://github.com/AtikulSoftware/smart-slider">
    <img src="https://avatars.githubusercontent.com/u/111883800?v=4" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Smart Slider Android</h3>

  <p align="center">
    Android Image Slider Library - Easy & Quick
    <br/>
    <br/>
    <a href="https://github.com/AtikulSoftware/smart-slider"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
    <a href="https://github.com/AtikulSoftware/smart-slider">View Demo</a>
    .
    <a href="https://github.com/AtikulSoftware/smart-slider/issues">Report Bug</a>
    .
    <a href="https://github.com/AtikulSoftware/smart-slider/issues">Request Feature</a>
  </p>
</p>

![Downloads](https://img.shields.io/github/downloads/AtikulSoftware/smart-slider/total) ![Contributors](https://img.shields.io/github/contributors/AtikulSoftware/smart-slider?color=dark-green) ![Forks](https://img.shields.io/github/forks/AtikulSoftware/smart-slider?style=social) ![Stargazers](https://img.shields.io/github/stars/AtikulSoftware/smart-slider?style=social) ![Issues](https://img.shields.io/github/issues/AtikulSoftware/smart-slider) ![License](https://img.shields.io/github/license/AtikulSoftware/smart-slider) 

## Table Of Contents

* [About the Project](#about-the-project)
* [Getting Started](#getting-started)
  * [Installation](#installation)
* [Contributing](#contributing)
* [License](#license)
* [Authors](#authors)

## About The Project

![Screen Shot](https://upload.wikimedia.org/wikipedia/commons/2/2c/Rotating_earth_%28large%29.gif)

Smart Slider Android is a powerful and versatile library for creating dynamic and interactive sliders in your Android applications. Whether you want to showcase images custom content, this library provides an easy-to-use solution with a wide range of customization options.


### Getting Started
Comprehensive documentation and code examples to get you started quickly.

> Step 1. Add the JitPack repository to your build file (settings.gradle)
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
                        ...
		}
	}
```

> Step 2. Add the dependency (build.gradle)
```
 implementation 'com.github.AtikulSoftware:smart-slider:1.0'
```

> Step 3. Add this xml code in you xml file 
```
<androidx.viewpager2.widget.ViewPager2
        android:layout_marginTop="20dp"
        android:id="@+id/smartSlider"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:paddingStart="80dp"
        android:paddingEnd="80dp"
        />
```

> Step 4 Add this java code in you java class
```
 ViewPager2 viewPager2 = findViewById(R.id.smartSlider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.img1,"image 1"));
        sliderItems.add(new SliderItem(R.drawable.img2,"Image 2"));
        sliderItems.add(new SliderItem(R.drawable.img3,"Image 3"));
        sliderItems.add(new SliderItem("https://atikulislam.xyz/images/hero.jpg","Image from url"));

        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2,5000));

        new SliderAdapter((position, title, view) -> {
            Toast.makeText(this, "Position: "+position+" Title: "+title, Toast.LENGTH_SHORT).show();
        });
```



### Installation

> Slider Item onClick
```
new SliderAdapter((position, title, view) -> {
            Toast.makeText(this, "Position: "+position+" Title: "+title, Toast.LENGTH_SHORT).show();
        });
```

## License

Distributed under the MIT License. See [LICENSE](https://github.com/AtikulSoftware/smart-slider/blob/main/LICENSE.md) for more information.

## Authors

* **Md Atikul Islam** - *Android Software Developer* - [Md Atikul Islam](https://github.com/AtikulSoftware) - *Easy & Quick Solution*
