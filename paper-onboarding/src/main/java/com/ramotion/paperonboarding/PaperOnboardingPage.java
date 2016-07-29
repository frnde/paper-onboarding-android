package com.ramotion.paperonboarding;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import java.io.Serializable;

/**
 * Represents content for one page of Paper Onboarding
 */
public class PaperOnboardingPage implements Serializable {

    private final int titleColor;
    private final int descriptionColor;
    private final int brandingIcon;
    private int titleText;
    private int descriptionText;
    private int bgColor;
    private int contentIconRes;
    private int bottomBarIconRes;

    public PaperOnboardingPage(Builder builder) {
        this.titleText = builder.titleText;
        this.descriptionText = builder.descriptionText;
        this.bgColor = builder.bgColor;
        this.titleColor = builder.titleColor;
        this.descriptionColor = builder.descriptionColor;
        this.contentIconRes = builder.contentIcon;
        this.bottomBarIconRes = builder.bottomIcon;
        this.brandingIcon = builder.brandingIcon;
    }

    public int getTitleText() {
        return titleText;
    }

    public int getDescriptionText() {
        return descriptionText;
    }

    public int getContentIconRes() {
        return contentIconRes;
    }

    public int getBottomBarIconRes() {
        return bottomBarIconRes;
    }

    public int getBgColor() {
        return bgColor;
    }

    public int getBrandingIcon() {
        return brandingIcon;
    }

    public int getDescriptionColor() {
        return descriptionColor;
    }

    public int getTitleColor() {
        return titleColor;
    }

    @Override
    public String toString() {
        return "PaperOnboardingPage{" +
                "titleText='" + titleText + '\'' +
                ", descriptionText='" + descriptionText + '\'' +
                ", bgColor=" + bgColor +
                ", titleColor=" + titleColor +
                ", descriptionColor=" + descriptionColor +
                ", contentIconRes=" + contentIconRes +
                ", brandingIconRes=" + brandingIcon +
                ", bottomBarIconRes=" + bottomBarIconRes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaperOnboardingPage that = (PaperOnboardingPage) o;

        if (titleColor != that.titleColor) return false;
        if (descriptionColor != that.descriptionColor) return false;
        if (brandingIcon != that.brandingIcon) return false;
        if (titleText != that.titleText) return false;
        if (descriptionText != that.descriptionText) return false;
        if (bgColor != that.bgColor) return false;
        if (contentIconRes != that.contentIconRes) return false;
        return bottomBarIconRes == that.bottomBarIconRes;

    }

    @Override
    public int hashCode() {
        int result = titleColor;
        result = 31 * result + descriptionColor;
        result = 31 * result + brandingIcon;
        result = 31 * result + titleText;
        result = 31 * result + descriptionText;
        result = 31 * result + bgColor;
        result = 31 * result + contentIconRes;
        result = 31 * result + bottomBarIconRes;
        return result;
    }

    /**
     * Builder for initializing a {@link PaperOnboardingPage} page.
     */
    public static class Builder {
        private int titleText;
        private int descriptionText;
        private int bgColor;
        private int titleColor;
        private int descriptionColor;
        private int contentIcon;
        private int bottomIcon;
        private int brandingIcon;

        /**
         * Constructor.
         *
         * @param bgColor         colorRes the backgroundColor.
         * @param contentIcon     drawableRes the top icon.
         * @param bottomIcon      drawableRes the pager's bottom icon.
         * @param titleText       stringRes the title test.
         * @param descriptionText stringRes the description text.
         */
        public Builder(@ColorRes int bgColor, @DrawableRes int contentIcon, @DrawableRes int bottomIcon,
                       @StringRes int titleText, @StringRes int descriptionText) {
            this.bgColor = bgColor;
            this.contentIcon = contentIcon;
            this.bottomIcon = bottomIcon;
            this.titleText = titleText;
            this.descriptionText = descriptionText;
            this.titleColor = Integer.MIN_VALUE;
            this.descriptionColor = Integer.MIN_VALUE;
            this.brandingIcon = Integer.MIN_VALUE;
        }

        /**
         * Optional colorRes to set the title text color.
         *
         * @param titleColor the colorRes.
         * @return the builder
         */
        public Builder withTitleColor(@ColorRes int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        /**
         * Optional colorRes to set the description test color.
         *
         * @param descriptionColor the colorRes.
         * @return the builder
         */
        public Builder withDescriptionColor(@ColorRes int descriptionColor) {
            this.descriptionColor = descriptionColor;
            return this;
        }

        /**
         * Optional drawableRes for the brandingIcon.
         *
         * @param brandingIcon the drawableRes.
         * @return the builder.
         */
        public Builder withBrandingIcon(@DrawableRes int brandingIcon) {
            this.brandingIcon = brandingIcon;
            return this;
        }

        /**
         * Builds a {@link PaperOnboardingPage} from this builder.
         *
         * @return the {@link PaperOnboardingPage}
         */
        public PaperOnboardingPage build() {
            return new PaperOnboardingPage(this);
        }
    }
}
