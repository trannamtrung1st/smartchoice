<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <xsl:param name="url"/>
    <jobItem>
      <url>
        <xsl:value-of select="$url"/>
      </url>
      <updatedDate>
        <xsl:value-of select="normalize-space(substring-after(/body/p[6]/span[3],'Ngày làm mới:'))"/>
      </updatedDate>
      
      <!--Company info-->
      <company>
        <xsl:apply-templates select="//*[@id='sidebar_ntd_info']"/>
        <name>
          <xsl:value-of select="/body/h3"/>
        </name>
        <address>
          <xsl:value-of select="/body/address"/>
        </address>  
      </company>

      <!--Job overview-->
      <jobName>
        <xsl:value-of select="//*[contains(@class,'box_chi_tiet_cong_viec')]//h1[contains(@class,'title_big')]"/>
      </jobName>
      <code>
        <xsl:value-of select="normalize-space(substring-after(//p[@class='text_grey2 font12 mt8 mb12']//span[2], 'Mã:'))"/>
      </code>

      <!--Job info-->
      <xsl:apply-templates select="//*[contains(@class,'job_detail')]"/>

      <!--Job detail-->
      <xsl:apply-templates select="//*[@id='ttd_detail']"/>
    </jobItem>
  </xsl:template>
  
  <!--Company info-->
  <xsl:template match="//*[@id='sidebar_ntd_info']">
    <code>
      <xsl:value-of select="a/@href"/>
    </code>
	<detailUrl>
      <xsl:value-of select="a/@href"/>
    </detailUrl>
    <image>
      <xsl:value-of select="a/div/img/@src"/>
    </image>
  </xsl:template>

  <!--Job info-->
  <xsl:template match="//*[contains(@class,'job_detail')]">
    <salaryRange>
      <xsl:value-of select="//i[contains(@class,'icon-money')]/following-sibling::span/span[@class='job_value']"/>
    </salaryRange>
    <expRequirement>
      <xsl:value-of select="//i[contains(@class,'icon-exp')]/following-sibling::span/span[@class='job_value']"/>
    </expRequirement>
    <degreeRequirement>
      <xsl:value-of select="//i[contains(@class,'icon-edu')]/following-sibling::span/span[@class='job_value']"/>
    </degreeRequirement>
    <numOfVacancy>
      <xsl:value-of select="//i[contains(@class,'icon-quantity')]/following-sibling::span/span[@class='job_value']"/>
    </numOfVacancy>
    <careerFields>
      <xsl:for-each select="//i[contains(@class,'icon-career')]/following-sibling::h2/a[contains(@class,'job_value')]">
        <item>
          <xsl:value-of select="."/>
        </item>
      </xsl:for-each>
    </careerFields>
    <workLocations>
      <xsl:for-each select="//i[contains(@class,'icon-address')]/following-sibling::span/a[contains(@class,'job_value')]">
        <item>
          <xsl:value-of select="."/>
        </item>
      </xsl:for-each>
    </workLocations>
    <genderRequirement>
      <xsl:value-of select="//i[contains(@class,'icon-gender')]/following-sibling::span/span[@class='job_value']"/>
    </genderRequirement>
  </xsl:template>

  <!--Job detail-->
  <xsl:template match="//*[@id='ttd_detail']">
    <description>
      <xsl:value-of select="normalize-space(following-sibling::*[@class='col-md-9 pr_0 mb_0 word_break'][1])"/>
    </description>
    <benefit>
      <xsl:value-of select="normalize-space(following-sibling::*[@class='col-md-9 pr_0 mb_0 word_break'][2])"/>
    </benefit>
    <otherRequirement>
      <xsl:value-of select="normalize-space(following-sibling::*[@class='col-md-9 pr_0 mb_0 word_break'][3])"/>
    </otherRequirement>
    <expiredDate>
      <xsl:value-of select="following-sibling::*[@class='col-md-9 pr_0 mb_0'][2]/span/span/span/span"/>
    </expiredDate>
    <contactPerson>
      <xsl:value-of select="following-sibling::*[@class='col-md-9 pr_0 mb_0'][3]"/>
    </contactPerson>
    <contactAddress>
      <xsl:value-of select="following-sibling::*[@class='col-md-9 pr_0 mb_0'][4]"/>
    </contactAddress>
  </xsl:template>
</xsl:stylesheet>